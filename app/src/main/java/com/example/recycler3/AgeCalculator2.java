package com.example.recycler3;

import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AgeCalculator2 {
    int day, mount, age;
    int dayCurrent = 0, mountCurrent = 0, ageCurrent = 0;
    int dayResult = 0, mountResult = 0, ageResult = 0;
    int intResult = 0;
    int countDay = 0;

    String textResult = "";
    String oneDay = " день", smallDay = " дня", largeDay = " дней";
    String oneMount =  " месяц", smallMount = " месяца", largeMount = " месяцев";
    String oneAge = " год", smallAge = " года", largeAge = " лет";

    public void ageCalculator(String dayS, String mountS, String ageS, ArrayList list, String animal ) {

        SimpleDateFormat datD = new SimpleDateFormat("dd");
        String currentDateandD = datD.format(new Date());
        String data1 = ("" + currentDateandD);
        dayCurrent = Integer.parseInt(data1);
        day = Integer.parseInt(dayS);
        dayResult = dayCurrent - day;

        SimpleDateFormat datM = new SimpleDateFormat("MM");
        String currentDateandM = datM.format(new Date());
        String data2 = ("" + currentDateandM);
        mountCurrent = Integer.parseInt(data2);
        mount = Integer.parseInt(mountS);
        mountResult = mountCurrent - mount;

        SimpleDateFormat datY = new SimpleDateFormat("yyyy");
        String currentDateandY = datY.format(new Date());
        String data3 = ("" + currentDateandY);
        ageCurrent = Integer.parseInt(data3);
        age = Integer.parseInt(ageS);
        ageResult = ageCurrent - age;

        if (ageResult > 1) {
            if (mountResult < 0) {
                ageResult--;
            }
            intResult = ageResult;
            calcAge(ageResult);
        }
        if (ageResult == 1) {
            if (mountResult >= 0) {
                intResult = ageResult;
                calcAge(ageResult);
            } else {
                mountResult = mountResult + 12;
                intResult = mountResult;
                calcMount(mountResult);
            }
        } else if (ageResult == 0) {
            if (mountResult > 1) {
                if (dayResult >= 0) {
                    intResult = mountResult;
                    if (mountResult == 2 || mountResult == 3 || mountResult == 4) {
                        textResult = "месяца";
                    } else {
                        textResult = "месяцев";
                    }
                } else {
                    mountResult = mountResult - 1;
                    intResult = mountResult;
                    calcMount(mountResult);
                }

            } else if (mountResult == 1) {
                if (dayResult >= 0) {
                    intResult = mountResult;
                    textResult = "месяц";
                } else {
                    if (age == 2022) {
                        switch (mount) {
                            case 1:
                                countDay = 31;
                                break;
                            case 2:
                                countDay = 28;
                                break;
                            case 3:
                                countDay = 31;
                                break;
                            case 4:
                                countDay = 30;
                                break;
                            case 5:
                                countDay = 31;
                                break;
                            case 6:
                                countDay = 30;
                                break;
                            case 7:
                                countDay = 31;
                                break;
                            case 8:
                                countDay = 28;
                                break;
                            case 9:
                                countDay = 30;
                                break;
                            case 10:
                                countDay = 31;
                                break;
                            case 11:
                                countDay = 30;
                                break;
                            case 12:
                                countDay = 31;
                                break;
                        }
                    } else if (age == 2023) {
                        switch (mount) {
                            case 1:
                                countDay = 31;
                            case 2:
                                countDay = 28;
                            case 3:
                                countDay = 31;
                            case 4:
                                countDay = 30;
                            case 5:
                                countDay = 31;
                            case 6:
                                countDay = 30;
                            case 7:
                                countDay = 31;
                            case 8:
                                countDay = 31;
                            case 9:
                                countDay = 30;
                            case 10:
                                countDay = 31;
                            case 11:
                                countDay = 30;
                            case 12:
                                countDay = 31;
                        }
                    }
                    dayResult = dayResult + countDay;
                    intResult = dayResult;
                    calcDay(dayResult);
                }
            } else {
                if (dayResult > 0) {
                    intResult = dayResult;
                    calcDay(dayResult);
                } else if (dayResult == 0) {
                    intResult = dayResult;
                    calcDay(dayResult);
                }
            }
        }

        textResult = animal + "," + " " + intResult + textResult;
        list.add(textResult);
    }

    private void calcDay(int dayResult) {
        if (dayResult == 1) {
            textResult = oneDay;
        } else if (dayResult == 2 || dayResult == 3 || dayResult == 4) {
            textResult = smallDay;
        } else if (dayResult > 4) {
            textResult = largeDay;
        } else if (dayResult == 0) {
            textResult = largeDay;
        }
    }

    private void calcMount(int mountResult) {
        if (mountResult == 1) {
            textResult = oneMount;
        } else if (mountResult == 2 || mountResult == 3 || mountResult == 4) {
            textResult = smallMount;
        } else if (mountResult > 4) {
            textResult = largeMount;
        }
    }

    private void calcAge(int ageResult) {
        if (ageResult == 1) {
            textResult = oneAge;
        } else if (ageResult == 2 || ageResult == 3 || ageResult == 4) {
            textResult = smallAge;
        } else if (ageResult > 4) {
            textResult = largeAge;
        }
    }
}
