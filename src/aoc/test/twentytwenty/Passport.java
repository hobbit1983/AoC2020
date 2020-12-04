package aoc.test.twentytwenty;

import java.util.ArrayList;

public class Passport {

    private boolean hcl = false;
    private boolean iyr = false;
    private boolean eyr = false;
    private boolean ecl = false;
    private boolean pid = false;
    private boolean byr = false;
    private boolean hgt = false;
    private boolean cid = false;

    public Passport(ArrayList<String> input){
        for(String s:input){
            if(s.contains("hcl:")){
                String value = getValue(s, "hcl:");
                if(value.matches("[#][a-f0-9]{6}")){
                     this.hcl = true;
                }
            }
                
            if(s.contains("iyr:")){
                String value = getValue(s, "iyr:");
                int year = Integer.parseInt(value);
                if(year >= 2010 && year <=2020)
                    this.iyr = true;
            }
                
            if(s.contains("eyr:")){
                String value = getValue(s, "eyr:");
                int year = Integer.parseInt(value);
                if(year >= 2020 && year <=2030)
                    this.eyr = true;
            }
                
            if(s.contains("ecl:")){
                String value =  getValue(s, "ecl:");
                if(value.equals("amb") || value.equals("blu") || value.equals("brn") || value.equals("gry") || value.equals("grn") || value.equals("hzl") || value.equals("oth")){
                    this.ecl = true;
                }
            }
                  
            if(s.contains("pid:")){
                if(getValue(s, "pid:").matches("[0-9]{9}")){
                    this.pid = true;
                }
            }
                  
            if(s.contains("byr:")){
                String value = getValue(s, "byr:");
                int year = Integer.parseInt(value);
                if(year >= 1920 && year <=2002)
                    this.byr = true;
            }
                
            if(s.contains("hgt:")){
                String value = getValue(s,"hgt:");
                if(value.endsWith("cm")){
                    int cm = Integer.parseInt(value.substring(0, value.indexOf("cm")));
                    if(cm>=150 && cm<=193)
                        this.hgt = true;     
                }
                if(value.endsWith("in")){
                    int in = Integer.parseInt(value.substring(0, value.indexOf("in")));
                    if(in>=59 && in<=76)
                        this.hgt = true;     
                }
            }
                    
            if(s.contains("cid:")){
                this.cid = true;
            }
                
        }

    }

    private String getValue(String input, String token){
        int index = input.indexOf(token) + token.length();
        String s = input.substring(index);
        if(s.contains(" ")){ 
            return s.substring(0, s.indexOf(" "));
        }
        else
            return s;
    }

    public boolean isValid(){
        if(hcl && iyr && eyr && ecl && pid && byr && hgt)
            return true;
        else
            return false;
    }
    
}
