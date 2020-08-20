package com.example.pico_placa_predictor;

import android.os.Build;
import android.util.Log;
import android.widget.CalendarView;

import androidx.annotation.RequiresApi;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Validacion {
    Calendar c = Calendar.getInstance();
    int Day=0,Month=0,Year=0;

    public void setFecha(int dia,int mes ,int year){
        Day=dia;
        Month=mes;
        Year=year;
        c.set(year, mes, dia);
    }
    public  boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
    public boolean PlacaCorrecta(String placa ){
        boolean valido=false;
        if(placa.length() == 7) {
            if(!isNumeric(placa.substring(0, 2)) && isNumeric(placa.substring(3, 6))){
                valido=true;
            }
        }
        return valido;
    }
    public boolean horaBien(int hora){
        boolean res=false;
        if(hora>=0&&hora<=23){
            res=true;
        }else{
            res=false;
        }
        return res;
    }

    /*public static String getDayOfWeek(String date){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).getDayOfWeek().name();
    }*/
    public boolean CirculaoNo(int numPlaca, int hora, String color) throws ParseException {
        boolean Circula=false;
        /*String input_date=""+Day+"/"+Month+"/"+Year;
       String DIA= getDayOfWeek(input_date);*/


        switch(color){
            case "ROJO":
                switch(Day){
                    case 17:
                    case 19:
                    case 21:
                        if(numPlaca%2!=0&&hora>5&&hora<18){
                            Circula=true;
                        }else{
                            Circula=false;
                        }

                        break;
                    case 18:
                    case 20:
                    case 22:
                        if(numPlaca%2==0&&hora>5&&hora<18){
                            Circula=true;
                        }else{
                            Circula=false;
                        }

                        break;

                    case 23:
                        Circula=false;

                        break;
                }
                break;
            case "AMARILLO":
                switch(Day){
                    case 17:
                    case 19:
                    case 21:
                        if(numPlaca%2!=0&&hora>5&&hora<21){
                            Circula=true;
                        }else{
                            Circula=false;
                        }

                        break;
                    case 18:
                    case 20:
                    case 22:
                        if(numPlaca%2==0&&hora>5&&hora<21){
                            Circula=true;
                        }else{
                            Circula=false;
                        }

                        break;

                    case 23:
                        Circula=false;

                        break;
                }
                break;

            case "VERDE":
                switch(Day){
                    case 17:
                        switch(numPlaca){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 7:
                            case 9:
                                Circula=true;
                                break;
                            case 6:
                            case 8:
                                Circula=false;
                                break;

                        }
                        break;
                    case 18:
                        switch(numPlaca){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 6:
                            case 8:
                            case 0:
                                Circula=true;
                                break;
                            case 5:
                            case 7:
                            case 9:
                                Circula=false;
                                break;
                        }
                        break;
                    case 19:
                        switch(numPlaca){
                            case 1:
                            case 2:
                            case 3:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                                Circula=true;
                                break;
                            case 4:
                            case 0:
                                Circula=false;
                                break;

                        }
                        break;
                    case 20:
                        switch(numPlaca){
                            case 2:
                            case 3:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 0:
                                Circula=true;
                                break;
                            case 1:
                            case 4:
                                Circula=false;
                                break;

                        }
                        break;
                    case 21:
                        switch(numPlaca){
                            case 1:
                            case 3:
                            case 5:
                            case 7:
                            case 4:
                            case 9:
                            case 0:
                                Circula=true;
                                break;
                            case 2:
                            case 6:
                            case 8:
                                Circula=false;
                                break;

                        }
                        break;
                    case 22:
                        switch(numPlaca){
                            case 2:
                            case 4:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 0:
                                Circula=true;
                                break;
                            case 1:
                            case 3:
                            case 5:
                                Circula=false;
                                break;

                        }
                        break;
                    case 23:
                        switch(numPlaca){
                            case 1:
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 0:
                                Circula=true;
                                break;
                            case 2:
                            case 4:
                            case 7:
                                Circula=false;
                                break;

                        }
                        break;
                }
                break;



        }
        return Circula;
    }
}
