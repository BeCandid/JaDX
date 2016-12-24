package defpackage;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GenericLoaderFactory */
public class mi {
    private static final mr c = new mi$1();
    private final Map<Class, Map<Class, ms>> a = new HashMap();
    private final Map<Class, Map<Class, mr>> b = new HashMap();
    private final Context d;

    public mi(Context context) {
        this.d = context.getApplicationContext();
    }

    public synchronized <T, Y> ms<T, Y> a(Class<T> modelClass, Class<Y> resourceClass, ms<T, Y> factory) {
        ms previous;
        this.b.clear();
        Map<Class, ms> resourceToFactories = (Map) this.a.get(modelClass);
        if (resourceToFactories == null) {
            resourceToFactories = new HashMap();
            this.a.put(modelClass, resourceToFactories);
        }
        previous = (ms) resourceToFactories.put(resourceClass, factory);
        if (previous != null) {
            for (Map<Class, ms> factories : this.a.values()) {
                if (factories.containsValue(previous)) {
                    previous = null;
                    break;
                }
            }
        }
        return previous;
    }

    public synchronized <T, Y> mr<T, Y> a(Class<T> modelClass, Class<Y> resourceClass) {
        mr<T, Y> mrVar;
        mr<T, Y> result = c(modelClass, resourceClass);
        if (result == null) {
            ms<T, Y> factory = d(modelClass, resourceClass);
            if (factory != null) {
                result = factory.a(this.d, this);
                a((Class) modelClass, (Class) resourceClass, (mr) result);
            } else {
                b(modelClass, resourceClass);
            }
            mrVar = result;
        } else if (c.equals(result)) {
            mrVar = null;
        } else {
            mrVar = result;
        }
        return mrVar;
    }

    private <T, Y> void b(Class<T> modelClass, Class<Y> resourceClass) {
        a((Class) modelClass, (Class) resourceClass, c);
    }

    private <T, Y> void a(Class<T> modelClass, Class<Y> resourceClass, mr<T, Y> modelLoader) {
        Map<Class, mr> resourceToLoaders = (Map) this.b.get(modelClass);
        if (resourceToLoaders == null) {
            resourceToLoaders = new HashMap();
            this.b.put(modelClass, resourceToLoaders);
        }
        resourceToLoaders.put(resourceClass, modelLoader);
    }

    private <T, Y> mr<T, Y> c(Class<T> modelClass, Class<Y> resourceClass) {
        Map<Class, mr> resourceToLoaders = (Map) this.b.get(modelClass);
        if (resourceToLoaders != null) {
            return (mr) resourceToLoaders.get(resourceClass);
        }
        return null;
    }

    private <T, Y> ms<T, Y> d(Class<T> modelClass, Class<Y> resourceClass) {
        Map<Class, ms> resourceToFactories = (Map) this.a.get(modelClass);
        ms msVar = null;
        if (resourceToFactories != null) {
            msVar = (ms) resourceToFactories.get(resourceClass);
        }
        if (msVar == null) {
            for (Class<? super T> registeredModelClass : this.a.keySet()) {
                if (registeredModelClass.isAssignableFrom(modelClass)) {
                    Map<Class, ms> currentResourceToFactories = (Map) this.a.get(registeredModelClass);
                    if (currentResourceToFactories != null) {
                        msVar = (ms) currentResourceToFactories.get(resourceClass);
                        if (msVar != null) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return msVar;
    }
}
