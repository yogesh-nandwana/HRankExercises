package com.na.test;
class TimeConversionTest {
	public static void main(String[] args) {
		System.out.println(timeConversion("07:05:45PM"));
	}

    public static String timeConversion(String s) {
        //12:01:00PM
        //12:00:00AM
        String[] timeParts = s.split(":");
        int len = timeParts[2].length();
        String amPm = timeParts[2].substring(2,len);
        System.out.println(amPm);
        int hr = Integer.parseInt(timeParts[0]);
        int min = Integer.parseInt(timeParts[1]);
        int sec = Integer.parseInt(timeParts[2].substring(0,2));
        if(amPm.equals("AM")){
            if(hr>11){
                hr = hr%12;
            }
        }else{
            if(hr<12){
                hr = hr + 12;
            }
        }
        String hrStr = hr+"",minStr = min+"",secStr = sec+"";
        if(hr<10){
            hrStr = (hr==0)?"00":"0".concat(hr+"");    
        }
        if(min<10){
            minStr = (min==0)?"00":"0".concat(min+"");    
        }
        if(sec<10){
            secStr = (sec==0)?"00":"0".concat(sec+"");    
        }
        return hrStr+":"+minStr+":"+secStr;
    }
}