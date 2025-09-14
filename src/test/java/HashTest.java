import org.junit.jupiter.api.Test;

public class HashTest {
    @Test
    public void testHashCode() {
        Object obj = new Object();
        String str1 = "hello";
        String str2 = "hello";
        assert str1.hashCode() == str2.hashCode();
    }
}
