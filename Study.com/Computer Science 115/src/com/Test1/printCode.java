package com.Test1;

import java.util.Scanner;

public class printCode {
    public static void main(String[] args) {
        System.out.println("package com.Test1;\n" +
                "\n" +
                "import java.util.Arrays;\n" +
                "import java.util.Scanner;\n" +
                "\n" +
                "public class program {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        //        Setting initial variables for easier recall later\n" +
                "        int sum = 0;\n" +
                "        int amountOfGrades;\n" +
                "        int i;\n" +
                "        String letterGrade = \"\";\n" +
                "\n" +
                "//  Starting Program here\n" +
                "\n" +
                "//      This is to update how many grades are going to be inputted by the User and then sets the new array size\n" +
                "        System.out.println(\"How many grades do you want to enter? (To exit enter 999 or -1 to restart the program)\");\n" +
                "\n" +
                "        while (true) {\n" +
                "            Scanner input = new Scanner(System.in);\n" +
                "            amountOfGrades = input.nextInt();\n" +
                "            if (amountOfGrades <= 10 && amountOfGrades > 0) {\n" +
                "                break;\n" +
                "            } else if (amountOfGrades == 999) {\n" +
                "                System.exit(0);\n" +
                "            } else if (amountOfGrades == -1) {\n" +
                "                System.out.println(\"Restarting Program\");\n" +
                "                main(null);\n" +
                "            }\n" +
                "            System.out.println(\"Invalid input. \\nYou can only enter up to 10 grades. Try again: \");\n" +
                "        }\n" +
                "        int[] grades = new int[amountOfGrades];\n" +
                "\n" +
                "//      This performs the intake on the grades\n" +
                "        for (i = 0; i < amountOfGrades; i++) {\n" +
                "            System.out.println(\"Please enter Grade \" + (i + 1) + \" : (To exit enter 999 or enter -1 to restart the program)\");\n" +
                "            while (true) {\n" +
                "                Scanner in1 = new Scanner(System.in);\n" +
                "                int holdGrade = in1.nextInt();\n" +
                "                if (holdGrade <= 100 && holdGrade > -1) {\n" +
                "                    grades[i] = holdGrade;\n" +
                "                    sum += holdGrade;\n" +
                "                    break;\n" +
                "                } else if (holdGrade == 999) {\n" +
                "                    System.exit(0);\n" +
                "                } else if (holdGrade == -1) {\n" +
                "                    System.out.println(\"Restarting Program\");\n" +
                "                    main(null);\n" +
                "                }\n" +
                "\n" +
                "                System.out.println(\"Invalid input. \\nYou can only enter a score between 1 and 100 - Try again:\");\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "//  Verifying the data is intact prior to crunching the numbers\n" +
                "        System.out.println(\"Please confirm these grades are correct:\\n\" + Arrays.toString(grades) + \"\\nAre they correct? (Y/N)\");\n" +
                "        while (true) {\n" +
                "            Scanner keyboard = new Scanner(System.in);\n" +
                "            String holdYN = keyboard.nextLine();\n" +
                "            System.out.println(holdYN);\n" +
                "            if (holdYN.equals(\"Y\") || holdYN.equals(\"y\")) {\n" +
                "                break;\n" +
                "            } else if (holdYN.equals(\"N\") || holdYN.equals(\"n\")) {\n" +
                "                System.out.println(\"Please enter the proper grades.\");\n" +
                "                main(null);\n" +
                "            }\n" +
                "            System.out.println(\"Invalid input. \\nTry Y or N.\");\n" +
                "        }\n" +
                "\n" +
                "//        Printing out the average grade\n" +
                "        int average = sum / amountOfGrades;\n" +
                "        System.out.println(\"------------------------------------------\");\n" +
                "        System.out.println(\"Your average quiz grade is: \" + average);\n" +
                "        System.out.println(\"------------------------------------------\");\n" +
                "\n" +
                "//        Evaluate the letter grade\n" +
                "        if (90 <= average && average <= 100) {\n" +
                "            letterGrade = \"A\";\n" +
                "        } else if (80 <= average && average <= 89) {\n" +
                "            letterGrade = \"B\";\n" +
                "        } else if (70 <= average && average <= 79) {\n" +
                "            letterGrade = \"C\";\n" +
                "        } else if (60 <= average && average <= 69) {\n" +
                "            letterGrade = \"D\";\n" +
                "        } else if (0 <= average && average <= 59) {\n" +
                "            letterGrade = \"F\";\n" +
                "        }\n" +
                "\n" +
                "        //    Output letter grade\n" +
                "        System.out.println(\"Your letter grade is: \" + letterGrade);\n" +
                "        System.out.println(\"------------------------------------------\");\n" +
                "        System.out.println(\"Return to Main Menu (1) or Exit Program (2)\");\n" +
                "        while(true){\n" +
                "        Scanner exit = new Scanner(System.in);\n" +
                "        int holdEnd = exit.nextInt();\n" +
                "        if (holdEnd == 1) {\n" +
                "            solution.main(null);\n" +
                "        } else if (holdEnd == 2) {\n" +
                "            System.exit(0);\n" +
                "        }\n" +
                "        System.out.println(\"Invalid input. \\nYou can only enter 1 or 2! \");\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n");
        System.out.println("Return to Main Menu (1) or Exit Program (2)");
        while(true){
            Scanner exit = new Scanner(System.in);
            int holdEnd = exit.nextInt();
            if (holdEnd == 1) {
                solution.main(null);
            } else if (holdEnd == 2) {
                System.exit(0);
            }
            System.out.println("Invalid input. \nYou can only enter 1 or 2! ");
        }
    }
}
