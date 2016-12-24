package defpackage;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: TypeAdapters */
public final class ajs {
    public static final air<String> A = new ajs$8();
    public static final air<BigDecimal> B = new ajs$9();
    public static final air<BigInteger> C = new ajs$10();
    public static final ais D = ajs.a(String.class, A);
    public static final air<StringBuilder> E = new ajs$11();
    public static final ais F = ajs.a(StringBuilder.class, E);
    public static final air<StringBuffer> G = new ajs$13();
    public static final ais H = ajs.a(StringBuffer.class, G);
    public static final air<URL> I = new ajs$14();
    public static final ais J = ajs.a(URL.class, I);
    public static final air<URI> K = new ajs$15();
    public static final ais L = ajs.a(URI.class, K);
    public static final air<InetAddress> M = new ajs$16();
    public static final ais N = ajs.b(InetAddress.class, M);
    public static final air<UUID> O = new ajs$17();
    public static final ais P = ajs.a(UUID.class, O);
    public static final air<Currency> Q = new ajs$18().a();
    public static final ais R = ajs.a(Currency.class, Q);
    public static final ais S = new ajs$19();
    public static final air<Calendar> T = new ajs$20();
    public static final ais U = ajs.b(Calendar.class, GregorianCalendar.class, T);
    public static final air<Locale> V = new ajs$21();
    public static final ais W = ajs.a(Locale.class, V);
    public static final air<ail> X = new ajs$22();
    public static final ais Y = ajs.b(ail.class, X);
    public static final ais Z = new ajs$24();
    public static final air<Class> a = new ajs$1();
    public static final ais b = ajs.a(Class.class, a);
    public static final air<BitSet> c = new ajs$12();
    public static final ais d = ajs.a(BitSet.class, c);
    public static final air<Boolean> e = new ajs$23();
    public static final air<Boolean> f = new ajs$30();
    public static final ais g = ajs.a(Boolean.TYPE, Boolean.class, e);
    public static final air<Number> h = new ajs$31();
    public static final ais i = ajs.a(Byte.TYPE, Byte.class, h);
    public static final air<Number> j = new ajs$32();
    public static final ais k = ajs.a(Short.TYPE, Short.class, j);
    public static final air<Number> l = new ajs$33();
    public static final ais m = ajs.a(Integer.TYPE, Integer.class, l);
    public static final air<AtomicInteger> n = new ajs$34().a();
    public static final ais o = ajs.a(AtomicInteger.class, n);
    public static final air<AtomicBoolean> p = new ajs$35().a();
    public static final ais q = ajs.a(AtomicBoolean.class, p);
    public static final air<AtomicIntegerArray> r = new ajs$2().a();
    public static final ais s = ajs.a(AtomicIntegerArray.class, r);
    public static final air<Number> t = new ajs$3();
    public static final air<Number> u = new ajs$4();
    public static final air<Number> v = new ajs$5();
    public static final air<Number> w = new ajs$6();
    public static final ais x = ajs.a(Number.class, w);
    public static final air<Character> y = new ajs$7();
    public static final ais z = ajs.a(Character.TYPE, Character.class, y);

    public static <TT> ais a(Class<TT> type, air<TT> typeAdapter) {
        return new ajs$25(type, typeAdapter);
    }

    public static <TT> ais a(Class<TT> unboxed, Class<TT> boxed, air<? super TT> typeAdapter) {
        return new ajs$26(unboxed, boxed, typeAdapter);
    }

    public static <TT> ais b(Class<TT> base, Class<? extends TT> sub, air<? super TT> typeAdapter) {
        return new ajs$27(base, sub, typeAdapter);
    }

    public static <T1> ais b(Class<T1> clazz, air<T1> typeAdapter) {
        return new ajs$28(clazz, typeAdapter);
    }
}
