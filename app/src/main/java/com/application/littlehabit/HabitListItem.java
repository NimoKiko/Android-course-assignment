package com.application.littlehabit;

public class HabitListItem {

    private String HabitName;
    private String MotivationWord;
    private String Day;
    private String imgPath;


    public HabitListItem(String habitName, String motivationWord, String day, String imgPath) {
        this.HabitName = habitName;
        this.MotivationWord = motivationWord;
        this.Day = day;
        this.imgPath = imgPath;
    }

    public String getHabitName() {
        return HabitName;
    }

    public void setHabitName(String habitName) {
        this.HabitName = habitName;
    }

    public String getMotivationWord() {
        return MotivationWord;
    }

    public void setMotivationWord(String motivationWord) {
        this.MotivationWord = motivationWord;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        this.Day = day;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }


}
