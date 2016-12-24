package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

/* compiled from: ImageLoadingUtil */
public class is {
    public static void a(View loadingProgress, View loadingProgressContainer, Context context, int width, int progressBarSize, String sourceUrl, ImageView imageView, View gifPlayView, int waitForPlay, boolean needBitmapTransform) {
        if (needBitmapTransform) {
            jx.b(GossipApplication.a().getApplicationContext()).a(new is$a()).a((Object) sourceUrl).d().a(new RoundedCornersTransformation(context, jb.a(10, context), 0)).a(is.b(loadingProgress, loadingProgressContainer, context, width, progressBarSize, sourceUrl, imageView, gifPlayView, waitForPlay, needBitmapTransform)).a(DiskCacheStrategy.c).a(imageView);
            return;
        }
        jx.b(GossipApplication.a().getApplicationContext()).a(new is$a()).a((Object) sourceUrl).d().a(is.b(loadingProgress, loadingProgressContainer, context, width, progressBarSize, sourceUrl, imageView, gifPlayView, waitForPlay, needBitmapTransform)).a(DiskCacheStrategy.c).a(imageView);
    }

    private static qf<String, oh> a(View loadingProgress, View loadingProgressContainer, Context context, int width, ImageView imageView) {
        return new is$1(context, width, loadingProgress, loadingProgressContainer, imageView);
    }

    private static qf<String, oh> b(View loadingProgress, View loadingProgressContainer, Context context, int width, int progressBarSize, String sourceUrl, ImageView imageView, View gifPlayView, int waitForPlay, boolean needBitmapTransform) {
        return new is$2(context, gifPlayView, waitForPlay, loadingProgressContainer, loadingProgress, width, progressBarSize, needBitmapTransform, sourceUrl, imageView);
    }

    private static OkHttpClient b(View loadingProgress, View loadingProgressContainer, Context context, int width, int progressBarSize) {
        return new Builder().addInterceptor(new is$4(new is$3(context, loadingProgress, width, progressBarSize, loadingProgressContainer))).build();
    }

    private static void b(int width, View loadingProgress, View loadingProgressContainer) {
        loadingProgressContainer.setVisibility(8);
        loadingProgress.setVisibility(8);
    }

    private static void c(String sourceUrl, View loadingProgress, View loadingProgressContainer, Context context, int width, ImageView imageView) {
        jx.b(GossipApplication.a().getApplicationContext()).a(sourceUrl).a(is.a(loadingProgress, loadingProgressContainer, context, width, imageView)).a(DiskCacheStrategy.c).a(imageView);
    }

    private static void d(String sourceUrl, View loadingProgress, View loadingProgressContainer, Context context, int width, ImageView imageView) {
        jx.b(GossipApplication.a().getApplicationContext()).a(sourceUrl).a(new RoundedCornersTransformation(context, jb.a(10, context), 0)).a(is.a(loadingProgress, loadingProgressContainer, context, width, imageView)).a(DiskCacheStrategy.c).a(imageView);
    }
}
