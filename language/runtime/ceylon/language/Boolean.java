package ceylon.language;

import com.redhat.ceylon.compiler.java.Util;
import com.redhat.ceylon.compiler.java.metadata.CaseTypes;
import com.redhat.ceylon.compiler.java.metadata.Ceylon;
import com.redhat.ceylon.compiler.java.metadata.Class;
import com.redhat.ceylon.compiler.java.metadata.Ignore;
import com.redhat.ceylon.compiler.java.metadata.ValueType;
import com.redhat.ceylon.compiler.java.runtime.model.ReifiedType;
import com.redhat.ceylon.compiler.java.runtime.model.TypeDescriptor;

@Ceylon(major = 5)
@Class
@CaseTypes({"ceylon.language::true", "ceylon.language::false"})
@ValueType
public abstract class Boolean implements ReifiedType {

    static {
        Util.setLanguageAccess(new $LanguageAccess() {
            public <Element> ArraySequence<Element> newArraySequence(@Ignore TypeDescriptor $reifiedElement, Element[] array, long first, long length, boolean copy) {
                return new ArraySequence($reifiedElement, array, first, length, copy);
            }
        });
    }
    
    @Ignore
    public final static TypeDescriptor $TypeDescriptor = TypeDescriptor.klass(Boolean.class);

    @Ignore
    public static Boolean instance(boolean b) {
        return b ? true_.$get() : false_.$get();
    }

    @Ignore
    abstract public boolean booleanValue();
    
    @Ignore
    public static java.lang.String toString(boolean value) {
        return (value) ? true_.$get().toString() : false_.$get().toString();
    }
    
    @Ignore
    public static boolean equals(boolean value, java.lang.Object that) {
        if (that instanceof Boolean) {
            Boolean s = (Boolean)that;
            return value = s.booleanValue();
        }
        else {
            return false;
        }
    }

    @Override
    @Ignore
    public TypeDescriptor $getType() {
        return $TypeDescriptor;
    }
}
