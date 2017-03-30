package com.honghei.gank.ui.fragment.gank;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.graphics.Palette;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.honghei.gank.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

import static com.honghei.gank.MyApp.mContext;

/**
 * @author Honghei
 * @time 2017/3/30  9:55
 * @desc 显示图片，并提供图片保存功能。
 */
public class GankDetailActivity extends SwipeBackActivity {
    private CoordinatorLayout container;
    private FloatingActionButton mFab;
    private ImageView mImageView;
    String image_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank_image);

        image_url = getIntent().getStringExtra("image_url");

        initView();
        loadImage(image_url);


    }

    private void initView(){
        container = (CoordinatorLayout) findViewById(R.id.gank_image_container);
        mFab = (FloatingActionButton) findViewById(R.id.gank_image_fab);
        mImageView = (ImageView) findViewById(R.id.gank_image_iv);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //将页面中的图片保存到相册。
                mImageView.setDrawingCacheEnabled(true);
                mImageView.buildDrawingCache();
                mImageView.buildDrawingCache();
                Bitmap bitmap = mImageView.getDrawingCache();
                saveImageToGallery(GankDetailActivity.this,bitmap);
            }

        });

    }
    public  void saveImageToGallery(Context context, Bitmap bmp) {
        if (bmp == null){
//            ToastUtils.show(context, "保存出错了...");
            return;
        }
        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "gank");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
//
            Toast.makeText(this,"没有找到文件夹或者文件",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
//            ToastUtils.show(context, "保存出错了...");
            Toast.makeText(this,"保存出错了",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }catch (Exception e){
//            ToastUtils.show(context, "保存出错了...");
            Toast.makeText(this,"保存出错了....",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        // 最后通知图库更新
        try {
            MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), "", "");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "文件夹..", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(file);
        intent.setData(uri);
        context.sendBroadcast(intent);
        Snackbar.make(container,"保存成功!",Snackbar.LENGTH_SHORT).show();
    }



    private void loadImage(String image_url){
        if(!TextUtils.isEmpty(image_url))
            Glide.with(mContext).load(image_url).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).
                    placeholder(R.mipmap.fillbitmap).error(R.mipmap.fillbitmap).into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

                    mImageView.setImageBitmap(resource);

                    Palette.Builder builder = new Palette.Builder(resource);
                    builder.generate(new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(Palette palette) {
                            //获取样板
                       /* Vibrant(充满活力的)
                        * Vibrant dark(充满活力的黑)
                        * Vibrant light(充满活力的亮)
                        * Muted(柔和的)
                        * Muted dark(柔和的黑)
                        * Muted lighr(柔和的亮)*/
                            Palette.Swatch vibrant = palette.getVibrantSwatch();
                            Palette.Swatch mutedVibrant = palette.getMutedSwatch();
                            if(mutedVibrant!=null)
                                mFab.setBackgroundTintList(ColorStateList.valueOf(mutedVibrant.getRgb()));
                            if (vibrant != null) {
                                basedPalete2SetRgb(vibrant);
                                mFab.setBackgroundTintList(ColorStateList.valueOf(vibrant.getTitleTextColor()));
                                return;
                            }
                            vibrant = palette.getLightVibrantSwatch();
                            if (vibrant != null) {
                                basedPalete2SetRgb(vibrant);
                                return;
                            }
                            vibrant = palette.getLightMutedSwatch();
                            if (vibrant != null) {
                                basedPalete2SetRgb(vibrant);
                            }
                        }
                    });


                }
            });

    }


    private void basedPalete2SetRgb(Palette.Swatch vibrant){
        int rgb = vibrant.getRgb();
        container.setBackgroundColor(rgb);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            //设置状态栏的颜色
            window.setStatusBarColor(rgb);
            //设置导航栏的颜色
            window.setNavigationBarColor(rgb);
        }

    }

}
