package sunlearning.sunlearningdemo.utils.imageLoader;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by chenny on 2018/4/4.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        String host="http://sun-learning.com/";
        String url=host+path;
        Glide.with(context).load(url).into(imageView);




    }
}
