package sky.patterns;

import sky.utils.StringUtil;

public class Resume implements Cloneable {
    /**
     * 简历模式 Prototype 深复制、浅复制
     */
    private String name;
    private String sex;
    private String age;
    private String company;
    private String timeArea;

    private WorkExperience work;

    public Resume(String name) {
        this.name = name;
        work = new WorkExperience();
    }

    private Resume(WorkExperience work) {
        try {
            this.work = (WorkExperience) work.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * 设置个人信息
     */
    public void setPersonalInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    /*
     * 设置工作经历
     */
    public void setWorkExperience(String company, String timeArea) {
        // this.company = company;
        // this.timeArea = timeArea;
        work.setCompany(company);
        work.setWorkDate(timeArea);
    }

    /*
     * 显示
     */
    public void display() {
        System.out.println(name + sex + age);
        System.out.println(work.getCompany() + work.getWorkDate() + StringUtil.NEW_LINE);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Resume obj = new Resume(this.work);
        obj.name = this.name;
        obj.age = this.age;
        obj.sex = this.sex;
        obj.company = this.company;
        obj.timeArea = this.timeArea;
        // return super.clone();
        return obj;
    }
}
