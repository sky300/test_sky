package sky.patterns.factoryPattern;

public class NvWa {
    /**
     * 女娲类
     */
    public static void main(String[] args) {
        AbstractHumanFactory hf = new HumanFactory();

        WhiteHuman whiteHuman = hf.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
        System.out.println();

        BlackHuman bh = hf.createHuman(BlackHuman.class);
        bh.getColor();
        bh.talk();
        System.out.println();

        YellowHuman yh = hf.createHuman(YellowHuman.class);
        yh.getColor();
        yh.talk();

        hf.test();
    }
}
