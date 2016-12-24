package defpackage;

import android.content.Context;

/* compiled from: GenericTranscodeRequest */
public class jw<ModelType, DataType, ResourceType> extends jv<ModelType, DataType, ResourceType, ResourceType> {
    private final mr<ModelType, DataType> g;
    private final Class<DataType> h;
    private final Class<ResourceType> i;
    private final jz$d j;

    private static <A, T, Z, R> qc<A, T, Z, R> a(jx glide, mr<A, T> modelLoader, Class<T> dataClass, Class<Z> resourceClass, pf<Z, R> transcoder) {
        return new qb(modelLoader, transcoder, glide.b((Class) dataClass, (Class) resourceClass));
    }

    jw(Context context, jx glide, Class<ModelType> modelClass, mr<ModelType, DataType> modelLoader, Class<DataType> dataClass, Class<ResourceType> resourceClass, pt requestTracker, po lifecycle, jz$d optionsApplier) {
        super(context, modelClass, jw.a(glide, modelLoader, dataClass, resourceClass, ph.b()), resourceClass, glide, requestTracker, lifecycle);
        this.g = modelLoader;
        this.h = dataClass;
        this.i = resourceClass;
        this.j = optionsApplier;
    }
}
