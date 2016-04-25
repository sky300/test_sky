package sky.patterns;

public class MainResume {

    /**
     * 原型模式 Prototype（复制简历）
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume r = new Resume("张三");
        r.setPersonalInfo("男", "21");
        r.setWorkExperience("北京**公司", "Java工程师");

        Resume a = (Resume) r.clone();
        a.setWorkExperience("天津", "安卓工程师");

        Resume b = (Resume) r.clone();
        b.setPersonalInfo("女", "22");

        Resume c = (Resume) r.clone();
        c.setPersonalInfo("女", "19");
        c.setWorkExperience("大宇", "2011-2012");

        a.display();
        b.display();
        c.display();
        r.display();
    }

}
