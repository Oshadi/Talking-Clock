package com.oshadi.clock;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TalkingClockController {
	
	static Map<Integer, String> map = new HashMap<Integer, String>(){
        {
            put(0, "");
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
            put(4, "Four");
            put(5, "Five");
            put(6, "Six");
            put(7, "Seven");
            put(8, "Eight");
            put(9, "Nine");
        }
    };
    static Map<Integer, String> mapOne = new HashMap<Integer, String>(){
        {
            put(0, "Ten");
            put(1, "Eleven");
            put(2, "Twelve");
            put(3, "Thirteen");
            put(4, "Fourteen");
            put(5, "Fifteen");
            put(6, "Sixteen");
            put(7, "SevenTeen");
            put(8, "Eighteen");
            put(9, "Nineteen");
        }
    };
	int hr=0;
	int mn=0;
	
	@GetMapping("{time}")
	public TalkingClock getTalkingTime(@PathVariable ("time") String time) {
		
		String result= validateTime(time);
		return new TalkingClock(result);
	}
	
	public String validateTime(String timeStr){
		
		try {
            LocalTime.parse(timeStr);
            String[] parts = timeStr.split(":");
            hr = Integer.parseInt(parts[0]);
            mn = Integer.parseInt(parts[1]);
            return getTalkingClock(mn, hr);
        } catch (DateTimeParseException | NullPointerException e) {
        	return "invalid";
        }
		
	}
	
	public String getTalkingClock(int mn, int hr) {
		String firstTail = "o'clock";
        String secondTail = "";
        String returnValue ="";
		if (mn != 0) {
            int first=0;
            int sec=0;
            String strNum = Integer.toString(mn);
            int minutes=0;
            int leftMin=0;

            List<Integer> digits = new ArrayList<>();
            for (int i = 0; i < strNum.length(); i++) {
                digits.add(Integer.parseInt(String.valueOf(strNum.charAt(i))));
            }
            if(digits.size()==1){
                first = 0;
                sec = digits.get(0);
            }else{
                first = digits.get(0);
                sec = digits.get(1);
            }
            if (first == 0) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    if (sec == entry.getKey()) {
                        secondTail = entry.getValue()+" past";
                    }
                }
            }else if (first == 1) {
                for (Map.Entry<Integer, String> entryOne : mapOne.entrySet()) {
                    if (sec == entryOne.getKey()) {
                        secondTail = entryOne.getValue()+" past";
                    }
                }
            } else if (first == 2) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    if (sec == entry.getKey()) {
                        secondTail = "Twenty " + entry.getValue() +" past";
                    }
                }
            } else if (first == 3) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    if(sec==0){
                        secondTail = "Half past";
                    }else if (sec == entry.getKey()) {
                        minutes= 30+entry.getKey();
                        leftMin=60-minutes;
                        hr=hr+1;
                        secondTail=calRedMinuts(hr,leftMin);
                    }
                }
            }else if (first == 4) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    if (sec == entry.getKey()) {
                        minutes= 40+entry.getKey();
                        leftMin=60-minutes;
                        hr=hr+1;
                        secondTail=calRedMinuts(hr,leftMin);
                    }
                }
            }else if (first == 5) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    if (sec == entry.getKey()) {
                        minutes= 50+entry.getKey();
                        leftMin=60-minutes;
                        hr=hr+1;
                        secondTail=calRedMinuts(hr,leftMin);
                    }
                }
            }
            if (hr == 1 || hr == 13) {
            	returnValue=(secondTail+" One" );
            } else if (hr == 2 || hr == 14) {
            	returnValue=(secondTail+" Two" );
            } else if (hr == 3 || hr == 15) {
            	returnValue=(secondTail+ " Three");
            } else if (hr == 4 || hr == 16) {
            	returnValue=(secondTail+ " Four" );
            } else if (hr == 5 || hr == 17) {
            	returnValue=(secondTail+ " Five" );
            } else if (hr == 6 || hr == 18) {
            	returnValue=(secondTail+ " Six" );
            } else if (hr == 7 || hr == 19) {
            	returnValue=(secondTail+ " Seven" );
            } else if (hr == 8 || hr == 20) {
            	returnValue=(secondTail+ " Eight" );
            } else if (hr == 9 || hr == 21) {
            	returnValue=(secondTail+ " Nine" );
            } else if (hr == 10 || hr == 22) {
            	returnValue=(secondTail+ " Ten" );
            } else if (hr == 11 || hr == 23) {
            	returnValue=(secondTail+ " Eleven" );
            } else if (hr == 12 || hr == 00) {
            	returnValue=(secondTail+ " Twelve" );
            }
        } else {
            if (hr == 1 || hr == 13) {
            	returnValue=("One " + firstTail);
            } else if (hr == 2 || hr == 14) {
            	returnValue=("Two " + firstTail);
            } else if (hr == 3 || hr == 15) {
            	returnValue=("Three " + firstTail);
            } else if (hr == 4 || hr == 16) {
            	returnValue=("Four " + firstTail);
            } else if (hr == 5 || hr == 17) {
            	returnValue=("Five " + firstTail);
            } else if (hr == 6 || hr == 18) {
            	returnValue=("Six " + firstTail);
            } else if (hr == 7 || hr == 19) {
            	returnValue=("Seven " + firstTail);
            } else if (hr == 8 || hr == 20) {
            	returnValue=("Eight " + firstTail);
            } else if (hr == 9 || hr == 21) {
            	returnValue=("Nine " + firstTail);
            } else if (hr == 10 || hr == 22) {
            	returnValue=("Ten " + firstTail);
            } else if (hr == 11 || hr == 23) {
            	returnValue=("Eleven " + firstTail);
            } else if (hr == 12 || hr == 00) {
            	returnValue=("Twelve " + firstTail);
            }
        }
		return returnValue;
	}
	
	 public static String calRedMinuts(int hr, int leftMin) {
         String leftStrNum = Integer.toString(leftMin);
         String twoEnd="";
         List<Integer> LeftDigits = new ArrayList<>();
         for (int m = 0; m < leftStrNum.length(); m++) {
             LeftDigits.add(Integer.parseInt(String.valueOf(leftStrNum.charAt(m))));
         }
         int ltfirst=0;
         int ltsec=0;
         if(LeftDigits.size()==1){
             ltfirst = 0;
             ltsec = LeftDigits.get(0);
         }else{
             ltfirst = LeftDigits.get(0);
             ltsec = LeftDigits.get(1);
         }
         if (ltfirst == 0) {
             for (Map.Entry<Integer, String> entry : map.entrySet()) {
                 if (ltsec == entry.getKey()) {
                     hr=hr+1;
                     twoEnd = entry.getValue() + " to";
                 }
             }
         }else if (ltfirst == 1) {
             for (Map.Entry<Integer, String> entryOne : mapOne.entrySet()) {
                 if (ltsec == entryOne.getKey()) {
                     hr=hr+1;
                     twoEnd = entryOne.getValue()+ " to";
                 }
             }
         } else if (ltfirst == 2) {
             for (Map.Entry<Integer, String> entry : map.entrySet()) {
                 if (ltsec == entry.getKey()) {
                     hr=hr+1;
                     twoEnd = "Twenty " + entry.getValue()+ " to";
                 }
             }
         }
         return twoEnd;
     }
	

}
