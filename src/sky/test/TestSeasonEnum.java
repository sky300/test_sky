package sky.test;

/**
 * 枚举方法测试
 * @author sky
 * @since 2012-2-18
 * @version 1.0
 */
public enum TestSeasonEnum {
    SPRING("春天"), SUMMER("夏天"), AUTUMN("秋天"), WINTER("冬天");
    private final String season;

    private TestSeasonEnum(String season) {
        this.season = season;
    }

    public String getSeason() {
        return this.season;
    }

    public static boolean isSeasonType(String season) {
        boolean isFalse = false;
        for (TestSeasonEnum seasonEnum : TestSeasonEnum.values()) {
            if (seasonEnum.getSeason().equals(season)) {
                return true;
            }
        }
        return isFalse;
    }

}
