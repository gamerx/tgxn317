
final class Animable_Sub4 extends Animable {
    
    public int anInt1571;
    public int anInt1572;
    private int anInt1573;
    private double aDouble1574;
    private double aDouble1575;
    private double aDouble1576;
    private double aDouble1577;
    private double aDouble1578;
    public boolean aBoolean1579;
    public int anInt1580;
    public int anInt1581;
    public int anInt1582;
    public int anInt1583;
    private int anInt1584;
    public double aDouble1585;
    public double aDouble1586;
    public double aDouble1587;
    public int anInt1588;
    public int anInt1589;
    public int anInt1590;
    private boolean aBoolean1591;
    private SpotAnim aSpotAnim_1592;
    private int anInt1593;
    private int anInt1594;
    public int anInt1595;
    public int anInt1596;
    public int anInt1597;
    
    public Animable_Sub4(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2) {
        anInt1573 = 9;
        aBoolean1579 = false;
        aBoolean1591 = true;
        aSpotAnim_1592 = SpotAnim.cache[l2];
        if (k != 46883) {
            aBoolean1591 = !aBoolean1591;
        }
        anInt1597 = k1;
        anInt1580 = j2;
        anInt1581 = i2;
        anInt1582 = l1;
        anInt1571 = l;
        anInt1572 = i1;
        anInt1588 = i;
        anInt1589 = j1;
        anInt1590 = k2;
        anInt1583 = j;
        aBoolean1579 = false;
    }
        
    public final void method455(int i, int j, int k, int l, byte byte0) {
        if (!aBoolean1579) {
            double d = l - anInt1580;
            double d2 = j - anInt1581;
            double d3 = Math.sqrt(d * d + d2 * d2);
            aDouble1585 = (double) anInt1580 + (d * (double) anInt1589) / d3;
            aDouble1586 = (double) anInt1581 + (d2 * (double) anInt1589) / d3;
            aDouble1587 = anInt1582;
        }
        double d1 = (anInt1572 + 1) - i;
        aDouble1574 = ((double) l - aDouble1585) / d1;
        if (byte0 != -83) {
            return;
        }
        aDouble1575 = ((double) j - aDouble1586) / d1;
        aDouble1576 = Math.sqrt(aDouble1574 * aDouble1574 + aDouble1575 * aDouble1575);
        if (!aBoolean1579) {
            aDouble1577 = -aDouble1576 * Math.tan((double) anInt1588 * 0.02454369D);
        }
        aDouble1578 = (2D * ((double) k - aDouble1587 - aDouble1577 * d1)) / (d1 * d1);
    }

    @Override
    public final Model getRotatedModel() {
        Model class30_sub2_sub4_sub6 = aSpotAnim_1592.getModel();
        if (class30_sub2_sub4_sub6 == null) {
            return null;
        }
        int j = -1;
        if (aSpotAnim_1592.aClass20_407 != null) {
            j = aSpotAnim_1592.aClass20_407.anIntArray353[anInt1593];
        }
        Model class30_sub2_sub4_sub6_1 = new Model(9, true, Class36.method532(j), false, class30_sub2_sub4_sub6);
        if (j != -1) {
            class30_sub2_sub4_sub6_1.method469((byte) -71);
            class30_sub2_sub4_sub6_1.method470(j, 40542);
            class30_sub2_sub4_sub6_1.anIntArrayArray1658 = null;
            class30_sub2_sub4_sub6_1.anIntArrayArray1657 = null;
        }
        if (aSpotAnim_1592.anInt410 != 128 || aSpotAnim_1592.anInt411 != 128) {
            class30_sub2_sub4_sub6_1.method478(aSpotAnim_1592.anInt410, aSpotAnim_1592.anInt410, anInt1573, aSpotAnim_1592.anInt411);
        }
        class30_sub2_sub4_sub6_1.method474(anInt1596, 1);
        class30_sub2_sub4_sub6_1.method479(64 + aSpotAnim_1592.anInt413, 850 + aSpotAnim_1592.anInt414, -30, -50, -30, true);
        return class30_sub2_sub4_sub6_1;
    }

    public final void method456(int i, int j) {
        aBoolean1579 = true;
        aDouble1585 += aDouble1574 * (double) i;
        aDouble1586 += aDouble1575 * (double) i;
        aDouble1587 += aDouble1577 * (double) i + 0.5D * aDouble1578 * (double) i * (double) i;
        aDouble1577 += aDouble1578 * (double) i;
        if (j != 0) {
            anInt1584 = 16;
        }
        anInt1595 = (int) (Math.atan2(aDouble1574, aDouble1575) * 325.94900000000001D) + 1024 & 0x7ff;
        anInt1596 = (int) (Math.atan2(aDouble1577, aDouble1576) * 325.94900000000001D) & 0x7ff;
        if (aSpotAnim_1592.aClass20_407 != null) {
            for (anInt1594 += i; anInt1594 > aSpotAnim_1592.aClass20_407.method258(anInt1593);) {
                anInt1594 -= aSpotAnim_1592.aClass20_407.method258(anInt1593) + 1;
                anInt1593++;
                if (anInt1593 >= aSpotAnim_1592.aClass20_407.anInt352) {
                    anInt1593 = 0;
                }
            }
        }
    }
}
