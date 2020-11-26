package com.example.seu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class QuestionnaireActivity extends AppCompatActivity {
    public static Activity screen;

    TextView textViewQuestionNumber, textViewQuestion;
    RadioGroup radioGroup;
    List<Questionnaire> questions = new ArrayList<>();

    int questionCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        screen = this;

        radioGroup = findViewById(R.id.questionnaire_rg);
        textViewQuestion = findViewById(R.id.questionnaire_tv_question);
        textViewQuestionNumber = findViewById(R.id.questionnaire_tv_question_number);

        questionsData();

        setQuestionData();

    }

    private void questionsData() {
        Questionnaire question1 = new Questionnaire("هل أنت بصحة جيدة اليوم ؟", "");
        questions.add(question1);

        Questionnaire question2 = new Questionnaire("هل تتناول مضاد حيوي ؟", "");
        questions.add(question2);

        Questionnaire question3 = new Questionnaire("هل تتناول أي عقاقير أخرى مضادة للأمراض المعدية ؟", "");
        questions.add(question3);

        Questionnaire question4 = new Questionnaire("خلال 3 ايام الماضية : هل تناولت الأسبرين أو أي دواء يحتوى على الأسبرين ؟", "");
        questions.add(question4);

        Questionnaire question5 = new Questionnaire("للنساء خلال 6 اسابيع الماضية : هل أنت حامل الآن أو كنت حامل خلال الأسابيع الماضيه", "");
        questions.add(question5);

        Questionnaire question6 = new Questionnaire("خلال 8 اسابيع سابقة : هل شربت لبن حليب أبقار أو أغنام أو جمال غير مبستر أو تعاملت بشكل مباشر مع سوائل هذه الحيوانات", "");
        questions.add(question6);

        Questionnaire question7 = new Questionnaire("خلال 8 اسابيع سابقة : هل تلقيت أي تطعيمات", "");
        questions.add(question7);

        Questionnaire question8 = new Questionnaire("خلال 8 اسابيع الماضية : هل كنت على إتصال مباشر مع شخص تلقى لقاح الجدرى المائى( العنقز )", "");
        questions.add(question8);

        Questionnaire question9 = new Questionnaire("خلال 8 اسابيع الماضية : هل تبرعت بالدم أو البلازما أو صفائح  الدم", "");
        questions.add(question9);

        Questionnaire question10 = new Questionnaire("خلال 4 أشهر الماضية : هل تبرعت بوحدتى كريات دم حمراء باستخدام جهاز فصل مكونات الدم", "");
        questions.add(question10);

        Questionnaire question11 = new Questionnaire("خلال 12 شهر الماضية : هل كنت خارج المملكة", "");
        questions.add(question11);

        Questionnaire question12 = new Questionnaire("خلال 12 شهر الماضية : هل نقل لك دم", "");
        questions.add(question12);

        Questionnaire question13 = new Questionnaire("خلال 12 شهر الماضية : هل أجري لك عملية زراعة للأعضاء أو نخاع العظام", "");
        questions.add(question13);

        Questionnaire question14 = new Questionnaire("خلال 12 شهر الماضية: هل تعرضت عن طريق الجلد او العين او الانسجة المخاطية لدم شخص اخر", "");
        questions.add(question14);

        Questionnaire question15 = new Questionnaire("خلال 12 شهر الماضية : هل تعرضت لوخز غير مقصود بابره ملوثه بدم شخص اخر", "");
        questions.add(question15);

        Questionnaire question16 = new Questionnaire("خلال 12 شهر الماضية : هل إتصلت جنسيا بشخص مصاب بمرض نقص المناعة المكتسب ( الإيدز )", "");
        questions.add(question16);

        Questionnaire question17 = new Questionnaire("خلال 12 شهر الماضية : هل إتصلت جنسيا مع شخص ياخذ المال أو المخدرات مقابل الجنس", "");
        questions.add(question17);

        Questionnaire question18 = new Questionnaire("هل اصبت بالإيدز أو كان فخص الإيدز إيجابي", "");
        questions.add(question18);

        Questionnaire question19 = new Questionnaire("هل سبق لك أن إستخدمت إبره لتناول عقاقير أو مخدر أو منشطات لم توصف لك من قبل الطبيب", "");
        questions.add(question19);

        Questionnaire question20 = new Questionnaire("هل سبق لك أن إستخدمت عوامل تخثر الدم المركزة", "");
        questions.add(question20);

        Questionnaire question21 = new Questionnaire("هل سبق أن أصبت بإلتهاب كبد فيروسي أو بأي أمراض أخرى بالكبد", "");
        questions.add(question21);

        Questionnaire question22 = new Questionnaire("هل أصبت بمرض شاغاس أو داء البابسية أو داء اللشمانيا", "");
        questions.add(question22);

        Questionnaire question23 = new Questionnaire("هل أصبت بأي نوع من أمراض الدم أو الحمى", "");
        questions.add(question23);

        Questionnaire question24 = new Questionnaire("هل سبق أن أجري لك عملية فى الدماغ أو زراعة لانسجة الدماغ أو زراعة أنسجة أو أعضاء من مصدر غير بشري", "");
        questions.add(question24);

        Questionnaire question25 = new Questionnaire("هل سبق أن اصبت بالسرطان أو بأي مرض خبيث", "");
        questions.add(question25);

        Questionnaire question26 = new Questionnaire("هل سبق أن عانيت من مشاكل فى القلب أو الرئة", "");
        questions.add(question26);

        Questionnaire question27 = new Questionnaire("هل تعاني من مشاكل نزف الدم أو أمراض الدم", "");
        questions.add(question27);

        Questionnaire question28 = new Questionnaire("هل سبق أن تلقيت علاج هرموني ( هرمون النمو أو هرمون بالحقن )", "");
        questions.add(question28);

        Questionnaire question29 = new Questionnaire("هل سبق لك أو لأحد أقاربك الإصابه بمرض جنون البقر", "");
        questions.add(question29);

        Questionnaire question30 = new Questionnaire("هل سبق أن أصبت بالحمى المالطية", "");
        questions.add(question30);

        Questionnaire question31 = new Questionnaire("هل سبق وأن أصبت بأمراض مزمنة أو وراثية", "");
        questions.add(question31);

    }

    private void setQuestionData() {
        textViewQuestion.setText(questions.get(questionCounter).getQuestion());

        String questionNumber = "السؤال " + (questionCounter + 1) + " / " + questions.size();

        textViewQuestionNumber.setText(questionNumber);

    }

    public void nextQuestion(View view) {
        if (questionCounter >= questions.size() - 1) {
            Toast.makeText(this, "إنتهت الأسئلة", Toast.LENGTH_SHORT).show();

            MainActivity.donorData.setQuestionnaires(questions);

            startActivity(new Intent(this, DonorTypeActivity.class));
//            finish();
            return;
        }

        String answer = getAnswer();

        if (answer.isEmpty()) {
            Toast.makeText(this, "إختر إجابة", Toast.LENGTH_SHORT).show();
            return;
        }

        questions.get(questionCounter).setAnswer(answer);

        questionCounter++;

        setQuestionData();

    }

    private String getAnswer() {
        int id = radioGroup.getCheckedRadioButtonId();
        if (id == -1) {
            return "";
        }
        RadioButton radioButton = findViewById(id);
        return radioButton.getText().toString();
    }

    public void previousQuestion(View view) {
        if (questionCounter > 0) {

            questionCounter--;
            setQuestionData();
        }
    }


}
