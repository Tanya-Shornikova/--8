package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<Answer> answers = new ArrayList<>();
        questions.add(0,new Question("сколько ног у лошади?\n",
                Arrays.asList("1) 2 ","2) 4 ","3) 8 "), 2));

        questions.add(1,new Question("какое время года самое холодное?\n",
                Arrays.asList("1) зима ","2) осень ","3) лето "),1));

        questions.add(2,new Question("сколько процентоа воды в человеке?\n",
                Arrays.asList("1) 100 ","2) 40 ","3) 80 "),3));

        int count = questions.size();
        for (Question num: questions) {
            System.out.println(num.getQuestionText());
            for (String list : num.getAnswerVariants()) {
                System.out.println(list);
            }
            answers.add(questions.indexOf(num),new Answer(num,scanner.nextInt()));
            if (num.getRightAnswer() != answers.get(questions.indexOf(num)).getAnswer()) {
                count--;
            }
            System.out.println("\n");
        }

        if (count == questions.size()){
            System.out.println("Вы ответили на "+ count + " из " + questions.size() + " вопросов.\n");
        }
        else {
            System.out.println("Вы ответили на "+ count + " из " + questions.size() + " вопросов. Вы ошиблись в следующих вопросах: \n");
        }

        for (Question num: questions) {
            if (num.getRightAnswer() != answers.get(questions.indexOf(num)).getAnswer()){
                System.out.println(answers.get(questions.indexOf(num)));
            }
        }

    }
}
