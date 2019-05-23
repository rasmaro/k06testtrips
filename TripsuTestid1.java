import org.junit.*;
import static org.junit.Assert.*;
public class TripsuTestid1 {
	Trips laud = new Trips();
	@Test(expected = IllegalArgumentException.class)
	public void alustus1() {
		laud.alusta('S');
	}
	@Test
	public void korrahaldus() {
		laud.alusta('0');
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 2, 2);
		assertEquals('X', laud.kelleKord());
	}
	@Test(expected = java.lang.AssertionError.class)
	public void veaKontroll1() {
		laud.alusta('0');
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 0, 0);
		assertEquals('X', laud.kelleKord());
		laud.paiguta('X', 2, 1);
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 1, 0);
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 2, 0);
	}
	@Test
	public void veaKontroll2() {
		laud.alusta('0');
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 0, 0);
		assertEquals('X', laud.kelleKord());
		laud.paiguta('X', 2, 1);
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 1, 0);
		assertEquals('X', laud.kelleKord());
		laud.paiguta('X', 2, 1);
	}
	@Test
	public void veaKontroll3() {
		laud.alusta('0');
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 0, 0);
		assertEquals('X', laud.kelleKord());
		laud.paiguta('X', 2, 1);
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 1, 0);
		assertEquals('X', laud.kelleKord());
		laud.paiguta('X', 0, 0);
	}
	@Test
	public void voiduKontroll() {
		laud.alusta('0');
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 0, 0);
		assertEquals('X', laud.kelleKord());
		laud.paiguta('X', 2, 1);
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 1, 0);
		assertEquals('X', laud.kelleKord());
		laud.paiguta('X', 2, 2);
		assertEquals('0', laud.kelleKord());
		laud.paiguta('0', 2, 0);
		assertEquals(true, laud.kontrolliVoitu());
	}
}
