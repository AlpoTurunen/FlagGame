package com.example.flaggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class GameMood extends AppCompatActivity {

    private TextView countLabel;
    private ImageView questionImage;
    private Button enterBtn;
    private AutoCompleteTextView atv;
    private Button hintBtn;

    private String rightAnswer;
    private String capital;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    private int originalQuizArrayCount = 0;
    int totalQuizCount = Settings.questionCount;
    int independentCountriesIncluded = Settings.independentCountriesIncluded;
    int language = Settings.language;


    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();


    String[][] quizData = {
            // {"Image Name", "Right English Answer", "Right Finnish Answer", "Capital", 0 = Independent, 1 = Not Independent}
            {"afghanistan", "afghanistan", "Afghanistan", "Kabul", "0"},
            {"albania", "albania", "Albania", "Tirana", "0"},
            {"algeria", "algeria", "Algeria", "Alger", "0"},
            {"american_samoa", "american samoa", "Amerikan Samoa", "Pago Pago", "1"},
            {"andorra", "andorra", "Andorra", "Andorra la Vella", "0"},
            {"angola", "angola", "Angola", "Luanda", "0"},
            {"anguilla", "anguilla", "Anguilla", "The Valley", "1"},
            {"antigua_and_barbuda", "antigua and barbuda", "Antigua ja Barbuda", "St. Johns", "0"},
            {"argentina", "argentina", "Argentiina", "Buenos Aires", "0"},
            {"armenia", "armenia", "Armenia", "Yerevan", "0"},
            {"aruba", "aruba", "Aruba", "Oranjestad", "1"},
            {"australia", "australia", "Australia", "Canberra", "0"},
            {"austria", "austria", "Itävalta", "Vienna", "0"},
            {"azerbaijan", "azerbaijan", "Azerbaidzan", "Baku", "0"},
            {"bahamas", "bahamas", "Bahama", "Nassau", "0"},
            {"bahrain", "bahrain", "Bahrain", "Manama", "0"},
            {"bangladesh", "bangladesh", "Bangladesh", "Dhaka", "0"},
            {"barbados", "barbados", "Barbados", "Bridgetown", "0"},
            {"belarus", "belarus", "Valko-Venäjä", "Minsk", "0"},
            {"belgium", "belgium", "Belgia", "Brussels", "0"},
            {"belize", "belize", "Belize", "Belmopan", "0"},
            {"benin", "benin", "Benin", "Porto-Novo", "0"},
            {"bermuda", "bermuda", "Bermuda", "Hamilton", "1"},
            {"bhutan", "bhutan", "Bhutan", "Thimphu", "0"},
            {"bolivia", "bolivia", "Bolivia", "Sucre", "0"},
            {"bosnia", "bosnia", "Bosnia-Hertsegovina", "Sarajevo", "0"},
            {"botswana", "botswana", "Botswana", "Gaborone", "0"},
            {"brazil", "brazil", "Brasilia", "Brasilia", "0"},
            {"british_virgin_islands", "british virgin islands", "Brittiläiset Neitsytsaaret", "Road Town", "1"},
            {"brunei", "brunei", "Brunei", "Bandar Seri Begawan", "0"},
            {"bulgaria", "bulgaria", "Bulgaria", "Sofia", "0"},
            {"burkina_faso", "burkina faso", "Burkina Faso", "Ouagadougou", "0"},
            {"burundi", "burundi", "Burundi", "Gitega", "0"},
            {"cambodia", "cambodia", "Kambodza", "Phnom Penh", "0"},
            {"cameroon", "cameroon", "Kamerun", "Yaounde", "0"},
            {"canada", "canada", "Kanada", "Ottawa", "0"},
            {"cape_verde", "cape verde", "Kap Verde", "Praia", "0"},
            {"cayman_islands", "cayman islands", "Caymansaaret", "George Town", "1"},
            {"central_african_republic", "central african republic", "Keski-Afrikan tasavalta", "Bangui", "0"},
            {"chad", "chad", "Tsad", "N'Djamena", "0"},
            {"chile", "chile", "Chile", "Santiago", "0"},
            {"china", "china", "Kiina", "Beijing", "0"},
            {"christmas_island", "christmas island", "Joulusaari", "Flying Fish Cove", "1"},
            {"colombia", "colombia", "Kolumbia", "Bogota", "0"},
            {"comoros", "comoros", "Komorit", "Moroni", "0"},
            {"cook_islands", "cook islands", "Cook-Saaret", "Avarua", "1"},
            {"costa_rica", "costa_rica", "Costa Rica", "San Jose", "0"},
            {"cote_divoire", "cote divoire", "Norsunluurannikko", "Yamoussoukro", "0"},
            {"croatia", "croatia", "Kroatia", "Zagreb", "0"},
            {"cuba", "cuba", "Kuuba", "Havana", "0"},
            {"cyprus", "cyprus", "Kypros", "Nicosia", "0"},
            {"cyprus_northern", "cyprus northern", "Pohjois-Kypros", "North Nicosia", "0"},
            {"czech_republic", "czech republic", "Tsekki", "Prague", "0"},
            {"democratic_republic_of_the_congo", "democratic republic of the congo", "Kongon demokraattinen tasavalta", "Kinshasa", "0"},
            {"denmark", "denmark", "Tanska", "Copenhagen", "0"},
            {"djibouti", "djibouti", "Djibouti", "Djibouti", "0"},
            {"dominica", "dominica", "Dominica", "Roseau", "0"},
            {"dominican_republic", "dominican republic", "Dominikaaninen tasavalta", "Santo Domingo", "0"},
            {"ecuador", "ecuador", "Ecuador", "Quito", "0"},
            {"egypt", "egypt", "Egypti", "Cairo", "0"},
            {"el_salvador", "el_salvador", "El Salvador", "San Salvador", "0"},
            {"equatorial_guinea", "equatorial guinea", "Päiväntasaajan Guinea", "Malabo", "0"},
            {"eritrea", "eritrea", "Eritrea", "Asmara", "0"},
            {"estonia", "estonia", "Viro", "Tallinn", "0"},
            {"ethiopia", "ethiopia", "Etiopia", "Addis Ababa", "0"},
            {"falkland_islands", "falkland islands", "Falklandinsaaret", "Stanley", "1"},
            {"faroe_islands", "faroe islands", "Färsaaret", "Torshavn", "1"},
            {"fiji", "fiji", "Fidzi", "Suva", "0"},
            {"finland", "finland", "Suomi", "Helsinki", "0"},
            {"france", "france", "Ranska", "Paris", "0"},
            {"french_polynesia", "french polynesia", "Ranskan Polynesia", "Papeete", "1"},
            {"gabon", "gabon", "Gabon", "Libreville", "0"},
            {"gambia", "gambia", "Gambia", "Banjul", "0"},
            {"georgia", "georgia", "Georgia", "Tbilisi", "0"},
            {"germany", "germany", "Saksa", "Berlin", "0"},
            {"ghana", "ghana", "Ghana", "Accra", "0"},
            {"gibraltar", "gibraltar", "Gibraltar", "Gibraltar", "1"},
            {"greece", "greece", "Kreikka", "Athens", "0"},
            {"greenland", "greenland", "Grönlanti", "Nuuk", "1"},
            {"grenada", "grenada", "Grenada", "St. George's", "0"},
            {"guam", "guam", "Guam", "Hagatna", "1"},
            {"guatemala", "guatemala", "Guatemala", "Guatemala City", "0"},
            {"guinea", "guinea", "Guinea", "Conakry", "0"},
            {"guinea_bissau", "guinea bissau", "Guinea-Bissau", "Bissau", "0"},
            {"guyana", "guyana", "Guyana", "Georgetown", "0"},
            {"haiti", "haiti", "Haiti", "Port-au-Prince", "0"},
            {"honduras", "honduras", "Honduras", "Tegucigalpa", "0"},
            {"hong_kong", "hong kong", "Hongkong", "None (or de facto Tamar)", "1"},
            {"hungary", "hungary", "Unkari", "Budapest", "0"},
            {"iceland", "iceland", "Islanti", "Reykjavik", "0"},
            {"india", "india", "Intia", "New Delhi", "0"},
            {"indonesia", "indonesia", "Indonesia", "Jakarta", "0"},
            {"iran", "iran", "Iran", "Tehran", "0"},
            {"iraq", "iraq", "Irak", "Baghdad", "0"},
            {"ireland", "ireland", "Irlanti", "Dublin", "0"},
            {"israel", "israel", "Israel", "Jerusalem", "0"},
            {"italy", "italy", "Italia", "Rome", "0"},
            {"jamaica", "jamaica", "Jamaika", "Kingston", "0"},
            {"japan", "japan", "Japani", "Tokyo", "0"},
            {"jordan", "jordan", "Jordania", "Ammam", "0"},
            {"kazakhstan", "kazakhstan", "Kazakstan", "Nur-Sultan", "0"},
            {"kenya", "kenya", "Kenia", "Nairobi", "0"},
            {"kiribati", "kiribati", "Kiribati", "Tarawa", "0"},
            {"kuwait", "kuwait", "Kuwait", "Kuwait City", "0"},
            {"kyrgyzstan", "kyrgyzstan", "Kirgisia", "Bishkek", "0"},
            {"laos", "laos", "Laos", "Vientiane", "0"},
            {"latvia", "latvia", "Latvia", "Riga", "0"},
            {"lebanon", "lebanon", "Libanon", "Beirut", "0"},
            {"lesotho", "lesotho", "Lesotho", "Maseru", "0"},
            {"liberia", "liberia", "Liberia", "Monrovia", "0"},
            {"libya", "libya", "Libya", "Tripoli", "0"},
            {"liechtenstein", "liechtenstein", "Liechtenstein", "Vaduz", "0"},
            {"lithuania", "lithuania", "Liettua", "Vilnius", "0"},
            {"luxembourg", "luxembourg", "Luxemburg", "Luxembourg", "0"},
            {"macao", "macao", "Macao", "None", "1"},
            {"macedonia", "North-Macedonia", "Pohjois-Makedonia", "Skopje", "0"},
            {"madagascar", "madagascar", "Madagaskar", "Antananarivo", "0"},
            {"malawi", "malawi", "Malawi", "Lilongwe", "0"},
            {"malaysia", "malaysia", "Malesia", "Kuala Lumpur", "0"},
            {"maldives", "maldives", "Malediivit", "Male", "0"},
            {"mali", "mali", "Mali", "Bamako", "0"},
            {"malta", "malta", "Malta", "Valletta", "0"},
            {"marshall_islands", "marshall islands", "Marshallinsaaret", "Majuro", "0"},
            {"martinique", "martinique", "Martinique", "Fort-de-France", "1"},
            {"mauritania", "mauritania", "Mauritania", "Nouakchott", "0"},
            {"mauritius", "mauritius", "Mauritius", "Port Louis", "0"},
            {"mexico", "mexico", "Meksiko", "Mexico City", "0"},
            {"micronesia", "micronesia", "Mikronesia", "Palikir", "0"},
            {"moldova", "moldova", "Moldova", "Chișinau", "0"},
            {"monaco", "monaco", "Monaco", "Monaco", "0"},
            {"mongolia", "mongolia", "Mongolia", "Ulaanbaatar", "0"},
            {"montenegro", "Montenegro", "Montenegro", "Podgorica", "0"},
            {"montserrat", "montserrat", "Montserrat", "Plymouth", "1"},
            {"morocco", "morocco", "Marokko", "Rabat", "0"},
            {"mozambique", "mozambique", "Mosambik", "Maputo", "0"},
            {"myanmar", "myanmar", "Myanmar", "Naypuidaw", "0"},
            {"namibia", "namibia", "Namibia", "Windhoek", "0"},
            {"nauru", "nauru", "Nauru", "Yaren", "0"},
            {"nepal", "nepal", "Nepali", "Kathmandu", "0"},
            {"netherlands", "netherlands", "Alankomaat", "Amsterdam", "0"},
            {"netherlands_antilles", "netherlands antilles", "Alankomaiden Antillit", "Willemstad", "1"},
            {"new_zealand", "new zealand", "Uusi-Seelanti", "Wellington", "0"},
            {"nicaragua", "nicaragua", "Nicaragua", "Managua", "0"},
            {"niger", "niger", "Niger", "Niamey", "0"},
            {"nigeria", "nigeria", "Nigeria", "Abuja", "0"},
            {"niue", "niue", "Niue", "Alogi", "1"},
            {"norfolk_island", "norfolk island", "Norfolkinsaari", "Kingston", "1"},
            {"north_korea", "north korea", "Pohjois-Korea", "Pyongyang", "0"},
            {"norway", "norway", "Norja", "Oslo", "0"},
            {"oman", "oman", "Oman", "Muscat", "0"},
            {"pakistan", "pakistan", "Pakistan", "Islamabad", "0"},
            {"palau", "palau", "Palau", "Ngerulmud", "0"},
            {"panama", "panama", "Panama", "Panama City", "0"},
            {"palestina", "palestina", "Palestiina", "Ramallah", "0"},
            {"papua_new_guinea", "papua new guinea", "Papua-Uusi-Guinea", "Port Moresby", "0"},
            {"paraguay", "paraguay", "Paraguay", "Asuncion", "0"},
            {"peru", "peru", "Peru", "Lima", "0"},
            {"philippines", "philippines", "Filippiinit", "Manila", "0"},
            {"pitcairn_islands", "pitcairn islands", "Pitcairnsaaret", "Adamstown", "1"},
            {"poland", "poland", "Puola", "Warsaw", "0"},
            {"portugal", "portugal", "Portugali", "Lisbon", "0"},
            {"puerto_rico", "puerto rico", "Puerto Rico", "San Juan", "1"},
            {"qatar", "qatar", "Qatar", "Doha", "0"},
            {"republic_of_the_congo", "republic of the congo", "Kongon tasavalta", "Brazzaville", "0"},
            {"romania", "romania", "Romania", "Bucharest", "0"},
            {"russian_federation", "russian federation", "Venäjä", "Moscow", "0"},
            {"rwanda", "rwanda", "Ruanda", "Kigali", "0"},
            {"saint_kitts_and_nevis", "saint kitts and nevis", "Saint Kitts ja Nevis", "Basseterre", "0"},
            {"saint_lucia", "saint lucia", "Saint Lucia", "Castries", "0"},
            {"saint_pierre", "saint pierre", "Saint-Pierre", "St. Pierre", "1"},
            {"saint_vicent_and_the_grenadines", "saint vicent and the grenadines", "Saint Vincent ja Grenadiinit", "Kingstown", "0"},
            {"samoa", "samoa", "Samoa", "Apia", "0"},
            {"san_marino", "san marino", "San Marino", "San Marino", "0"},
            {"sao_tome_and_principe", "sao tome and principe", "Sao Tome ja Principe", "Sao Tome", "0"},
            {"saudi_arabia", "saudi arabia", "Saudi-Arabia", "Riyadh", "0"},
            {"senegal", "senegal", "Senegal", "Dakar", "0"},
            {"serbia", "serbia", "Serbia", "Belgrad", "0"},
            {"seychelles", "seychelles", "Seychellit", "Victoria", "0"},
            {"sierra_leone", "sierra leone", "Sierra Leone", "Freetown", "0"},
            {"singapore", "singapore", "Singapore", "Singapore", "0"},
            {"slovakia", "slovakia", "Slovakia", "Bratislava", "0"},
            {"slovenia", "slovenia", "Slovenia", "Ljubljana", "0"},
            {"soloman_islands", "soloman islands", "Solomaninsaaret", "Honiara", "0"},
            {"somalia", "somalia", "Somalia", "Mogadishu", "0"},
            {"south_africa", "south africa", "Etelä-Afrikka", "Pretoria, Cape Town, and Bloemfontein", "0"},
            {"south_georgia", "south georgia", "Etelä-Georgia", "King Edward Point", "1"},
            {"south_korea", "south korea", "Etelä-Korea", "Seoul", "0"},
            {"south_sudan", "South Sudan", "Etelä-Sudan", "Juba", "0"},
            {"soviet_union", "soviet union", "Neuvostoliitto", "Moscow", "1"},
            {"spain", "spain", "Espanja", "Madrid", "0"},
            {"sri_lanka", "sri lanka", "Sri Lanka", "Sri Jayawardenepura Kotte", "0"},
            {"sudan", "sudan", "Sudan", "Khartoum", "0"},
            {"suriname", "suriname", "Suriname", "Paramaribo", "0"},
            {"swaziland", "swaziland", "Swazimaa", "Mbabane", "0"},
            {"sweden", "sweden", "Ruotsi", "Stockholm", "0"},
            {"switzerland", "switzerland", "Sveitsi", "Bern", "0"},
            {"syria", "syria", "Syyria", "Damascus", "0"},
            {"taiwan", "taiwan", "Taiwan", "Taipei", "1"},
            {"tajikistan", "tajikistan", "Tadzikistan", "Dushanbe", "0"},
            {"tanzania", "tanzania", "Tansania", "Dodoma", "0"},
            {"thailand", "thailand", "Thaimaa", "Bangkok", "0"},
            {"tibet", "tibet", "Tiibet", "Lhasa", "0"},
            {"timor_leste", "timor leste", "Itä-Timor", "Dili", "0"},
            {"togo", "togo", "Togo", "Lome", "0"},
            {"tonga", "tonga", "Tonga", "Nuku alofa", "0"},
            {"trinidad_and_tobago", "trinidad and tobago", "Trinidad ja Tobago", "Port of Spain", "0"},
            {"tunisia", "tunisia", "Tunisia", "Tunis", "0"},
            {"turkey", "turkey", "Turkki", "Ankara", "0"},
            {"turkmenistan", "turkmenistan", "Turkmenistan", "Ashgabat", "0"},
            {"turks_and_caicos_islands", "turks and caicos islands", "Turks- ja Caicossaaret", "Cockburn Town", "1"},
            {"tuvalu", "tuvalu", "Tuvalu", "Funafuti", "0"},
            {"uae", "united arab emirates", "Yhdistyneet arabiemiirikunnat", "Abu Dhabi", "0"},
            {"uganda", "uganda", "Uganda", "Kampala", "0"},
            {"ukraine", "ukraine", "Ukraina", "Kiev", "0"},
            {"united_kingdom", "united kingdom", "Iso-Britannia", "London", "0"},
            {"united_states_of_america", "united states of america", "Yhdysvallat", "Washington", "0"},
            {"uruguay", "uruguay", "Uruguay", "Montevideo", "0"},
            {"us_virgin_islands", "us virgin islands", "Yhdysvaltain Neitsytsaaret", "Charlotte Amalie", "1"},
            {"uzbekistan", "uzbekistan", "Uzbekistan", "Tashkent", "0"},
            {"vanuatu", "vanuatu", "Vanuatu", "Port Vila", "0"},
            {"vatican_city", "vatican city", "Vatikaani", "Vatican City", "0"},
            {"venezuela", "venezuela", "Venezuela", "Caracas", "0"},
            {"vietnam", "vietnam", "Vietnam", "Hanoi", "0"},
            {"wallis_and_futuna", "wallis and futuna", "Wallis ja Futuna", "Mata-Utu", "1"},
            {"yemen", "yemen", "Jemen", "Sana'a", "0"},
            {"zambia", "zambia", "Sambia", "Lusaka", "0"},
            {"zimbabwe", "zimbabwe", "Zimbabwe", "Harare", "0"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peli_mood);

        countLabel = findViewById(R.id.countLabel);
        questionImage = findViewById(R.id.questionImage);
        enterBtn = findViewById(R.id.enterBtn);
        atv = findViewById(R.id.autoCompleteTextView);
        hintBtn = findViewById(R.id.hintBtn);


        for (int i = 1; i < quizData.length; i++){
            names.add(quizData[i][language]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, names);
        atv.setAdapter(adapter);

        // Suggests a suitable answer
        atv.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN){

                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        CheckAnswer();
                    }
                }

                return false;
            }
        });

        // Enter answer
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer();
            }
        });

        // Give hint
        hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hintBtn.setText(String.format("Capital is %s",capital));
            }
        });



        // Create quizArray from quizData.
        if (independentCountriesIncluded == 2){ // Exclude not-independent countries
            for (int i = 1; i < quizData.length; i++){
                if (Objects.equals(quizData[i][4], "0")){
                    // Prepare array.
                    ArrayList<String> tmpArray = new ArrayList<>();
                    tmpArray.add(quizData[i][0]); //Image name
                    tmpArray.add(quizData[i][1]); //Right english answer
                    tmpArray.add(quizData[i][2]); //Right finnish answer
                    tmpArray.add(quizData[i][3]); //Capital

                    quizArray.add(tmpArray);
                }
            }
        } else { // Include not-independent countries
            for (int i = 1; i < quizData.length; i++) {
                // Prepare array.
                ArrayList<String> tmpArray = new ArrayList<>();
                tmpArray.add(quizData[i][0]); //Image name
                tmpArray.add(quizData[i][1]); //Right english answer
                tmpArray.add(quizData[i][2]); //Right finnish answer
                tmpArray.add(quizData[i][3]); //Capital

                quizArray.add(tmpArray);
            }
        }
        originalQuizArrayCount = quizArray.size();
        showNextQuiz();
    }

    public void showNextQuiz() {
        // Update quizCountlabel.
        countLabel.setText("Question "+quizCount+"/"+totalQuizCount);

        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());
        hintBtn.setText("Hint");

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set image and right answer.
        // Array format: {"Image name", "Right English Language Answer", "Right Finnish Language Answer", "Capital"}
        questionImage.setImageResource(getResources().getIdentifier(quiz.get(0), "drawable", getPackageName()));
        rightAnswer = quiz.get(language); // 1 == English, 2 = Finnish
        capital = quiz.get(3);

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);
    }

    public void CheckAnswer() {

        // Get atv.
        String answer = atv.getText().toString();

        String alertTitle;

        if (answer.toLowerCase().equals(rightAnswer.toLowerCase())){
            // Correct
            alertTitle = "Correct!";
            rightAnswerCount++;
        } else {
            // Wrong
            alertTitle = "Wrong!";
        }

        // Create Dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        if (Objects.equals(alertTitle, "Wrong!")){
            builder.setIcon(R.drawable.sad_emoji);
        }else{builder.setIcon(R.drawable.happy_emoji);}
        builder.setMessage("Your answer: "+answer+". Right answer was: " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                atv.setText("");

                if (quizArray.size() <= (originalQuizArrayCount - totalQuizCount)) {
                    // quizArray is empty
                    showResults();

                } else {
                    quizCount++;
                    showNextQuiz();
                }

            }
        });
        builder.setCancelable(false);
        builder.show();


    }
    public void showResults(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Results");
        builder.setMessage(rightAnswerCount + " / "+totalQuizCount);
        builder.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                recreate();
            }
        });
        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();


    }




}
