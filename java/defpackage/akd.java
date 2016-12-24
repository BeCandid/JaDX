package defpackage;

import java.util.regex.Pattern;

/* compiled from: RegexCache */
public class akd {
    private akd$a<String, Pattern> a;

    public akd(int size) {
        this.a = new akd$a(size);
    }

    public Pattern a(String regex) {
        Pattern pattern = (Pattern) this.a.a((Object) regex);
        if (pattern != null) {
            return pattern;
        }
        pattern = Pattern.compile(regex);
        this.a.a(regex, pattern);
        return pattern;
    }
}
