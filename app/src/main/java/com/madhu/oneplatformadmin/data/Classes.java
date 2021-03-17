package com.madhu.oneplatformadmin.data;



public class Classes {
    public static class mark{       //Google sheet's column for the record tracking
        private static final int CRE2=1;
        private static final int ESO=CRE2+1;
        private static final int PDC=CRE2+2;
        private static final int HSIR=CRE2+3;
        private static final int ECRE=CRE2+4;
        private static final int CS=CRE2+5;
        private static final int IOT=CRE2+6;
        private static final int OT=CRE2+7;
        private static final int HT=CRE2+8;
        private static final int CRE=CRE2+9;
        private static final int PST=CRE2+10;
        private static final int HONS=CRE2+11;

        private static int[] classes={CRE2, ESO, PDC, HSIR, ECRE, CS, IOT, OT, HT, CRE, PST, HONS};

        public static String getColumn(int position){
            return String.valueOf(classes[position]);
        }




    }
    public static class rec{     //Google sheet's column for the classes tracking
        private static final int CRE2=17;
        private static final int ESO=CRE2+1;
        private static final int PDC=CRE2+2;
        private static final int HSIR=CRE2+3;
        private static final int ECRE=CRE2+4;
        private static final int CS=CRE2+5;
        private static final int IOT=CRE2+6;
        private static final int OT=CRE2+7;
        private static final int HT=CRE2+8;
        private static final int CRE=CRE2+9;
        private static final int PST=CRE2+10;
        private static final int HONS=CRE2+11;

        private static int[] classes={CRE2, ESO, PDC, HSIR, ECRE, CS, IOT, OT, HT, CRE, PST, HONS};

        public static String getColumn(int position){
            return String.valueOf(classes[position]);
        }

    }
    public static final String CRE2="CRE2";
    public static final String ESO="ESO";
    public static final String PDC="PDC";
    public static final String HSIR="Industrial Eco";
    public static final String ECRE="Electrochem (PE)";
    public static final String CS="OS (CS minor)";
    public static final String OT="Optimization technique (OE)";
    public static final String IOT="IoT (OE)";
    public static final String HT="HT Lab";
    public static final String CRE="CRE Lab";
    public static final String PST="PST Lab";
    public static final String HONS="Honours";

}
