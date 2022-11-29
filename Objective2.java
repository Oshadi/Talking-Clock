import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;
public class Objective2 {
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
        
        public static void TalkingClock (int hr, int mn) {
        	String firstTail = "o'clock";
            String secondTail = "";
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
                    System.out.println(secondTail+" One " );
                } else if (hr == 2 || hr == 14) {
                    System.out.println(secondTail+" Two " );
                } else if (hr == 3 || hr == 15) {
                    System.out.println(secondTail+ " Three ");
                } else if (hr == 4 || hr == 16) {
                    System.out.println(secondTail+ " Four" );
                } else if (hr == 5 || hr == 17) {
                    System.out.println(secondTail+ " Five " );
                } else if (hr == 6 || hr == 18) {
                    System.out.println(secondTail+ " Six " );
                } else if (hr == 7 || hr == 19) {
                    System.out.println(secondTail+ " Seven " );
                } else if (hr == 8 || hr == 20) {
                    System.out.println(secondTail+ " Eight " );
                } else if (hr == 9 || hr == 21) {
                    System.out.println(secondTail+ " Nine " );
                } else if (hr == 10 || hr == 22) {
                    System.out.println(secondTail+ " Ten " );
                } else if (hr == 11 || hr == 23) {
                    System.out.println(secondTail+ " Eleven " );
                } else if (hr == 12 || hr == 00) {
                    System.out.println(secondTail+ " Twelve " );
                }
            } else {
                if (hr == 1 || hr == 13) {
                    System.out.println("One " + firstTail);
                } else if (hr == 2 || hr == 14) {
                    System.out.println("Two " + firstTail);
                } else if (hr == 3 || hr == 15) {
                    System.out.println("Three " + firstTail);
                } else if (hr == 4 || hr == 16) {
                    System.out.println("Four " + firstTail);
                } else if (hr == 5 || hr == 17) {
                    System.out.println("Five " + firstTail);
                } else if (hr == 6 || hr == 18) {
                    System.out.println("Six " + firstTail);
                } else if (hr == 7 || hr == 19) {
                    System.out.println("Seven " + firstTail);
                } else if (hr == 8 || hr == 20) {
                    System.out.println("Eight " + firstTail);
                } else if (hr == 9 || hr == 21) {
                    System.out.println("Nine " + firstTail);
                } else if (hr == 10 || hr == 22) {
                    System.out.println("Ten " + firstTail);
                } else if (hr == 11 || hr == 23) {
                    System.out.println("Eleven " + firstTail);
                } else if (hr == 12 || hr == 00) {
                    System.out.println("Twelve " + firstTail);
                }
            }
        }
        
        //get the subtract value for after 30 minutes
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
        public static void main(String[] args) {
            int hr=0;
            int mn=0;
            //getting input from the command line
            Scanner scanner = new Scanner(System.in);
            System.out.println("=======================================");
            System.out.println("Enter Time in 24 hour Format. Ex: 13:54");
            System.out.println("=======================================");
            String timeStr = scanner.nextLine();
            //validate input
            try {
                LocalTime.parse(timeStr);
                String[] parts = timeStr.split(":");
                hr = Integer.parseInt(parts[0]);
                mn = Integer.parseInt(parts[1]);
                TalkingClock (hr, mn);
            } catch (DateTimeParseException | NullPointerException e) {
            	//return invalid message and exit
                System.out.println("Invalid time entered: " + timeStr);
                System.out.println("=======================================");
                System.exit(1);
            }
            
            
        }
    }

