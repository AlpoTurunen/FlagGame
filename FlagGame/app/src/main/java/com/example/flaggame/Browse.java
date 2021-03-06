package com.example.flaggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Browse extends AppCompatActivity {

    ListView mListView;


    String[] capitalNames = {
            "Kabul",
            "Tirana",
            "Alger",
            "Pago Pago",
            "Andorra la Vella",
            "Luanda",
            "The Valley",
            "St. Johns",
            "Buenos Aires",
            "Yerevan",
            "Oranjestad",
            "Canberra",
            "Vienna",
            "Baku",
            "Nassau",
            "Manama",
            "Dhaka",
            "Bridgetown",
            "Minsk",
            "Brussels",
            "Belmopan",
            "Porto-Novo",
            "Hamilton",
            "Thimphu",
            "Sucre",
            "Sarajevo",
            "Gaborone",
            "Brasilia",
            "Road Town",
            "Bandar Seri Begawan",
            "Sofia",
            "Ouagadougou",
            "Gitega",
            "Phnom Penh",
            "Yaounde",
            "Ottawa",
            "Praia",
            "George Town",
            "Bangui",
            "N'Djamena",
            "Santiago",
            "Beijing",
            "Flying Fish Cove",
            "Bogota",
            "Moroni",
            "Avarua",
            "San Jose",
            "Yamoussoukro",
            "Zagreb",
            "Havana",
            "Nicosia",
            "North Nicosia",
            "Prague",
            "Kinshasa",
            "Copenhagen",
            "Djibouti",
            "Roseau",
            "Santo Domingo",
            "Quito",
            "Cairo",
            "San Salvador",
            "Malabo",
            "Asmara",
            "Tallinn",
            "Addis Ababa",
            "Stanley",
            "Torshavn",
            "Suva",
            "Helsinki",
            "Paris",
            "Papeete",
            "Libreville",
            "Banjul",
            "Tbilisi",
            "Berlin",
            "Accra",
            "Gibraltar",
            "Athens",
            "Nuuk",
            "St. George s",
            "Hagatna",
            "Guatemala City",
            "Conakry",
            "Bissau",
            "Georgetown",
            "Port-au-Prince",
            "Tegucigalpa",
            "None (or de facto Tamar)",
            "Budapest",
            "Reykjavik",
            "New Delhi",
            "Jakarta",
            "Tehran",
            "Baghdad",
            "Dublin",
            "Jerusalem",
            "Rome",
            "Kingston",
            "Tokyo",
            "Ammam",
            "Nur-Sultan",
            "Nairobi",
            "Tarawa",
            "Kuwait City",
            "Bishkek",
            "Vientiane",
            "Riga",
            "Beirut",
            "Maseru",
            "Monrovia",
            "Tripoli",
            "Vaduz",
            "Vilnius",
            "Luxembourg",
            "None (part of China territory)",
            "Skopje",
            "Antananarivo",
            "Lilongwe",
            "Kuala Lumpur",
            "Male",
            "Bamako",
            "Valletta",
            "Majuro",
            "Fort-de-France",
            "Nouakchott",
            "Port Louis",
            "Mexico City",
            "Palikir",
            "Chișinau",
            "Monaco",
            "Ulaanbaatar",
            "Pocgorica",
            "Plymouth",
            "Rabat",
            "Maputo",
            "Naypuidaw",
            "Windhoek",
            "Yaren",
            "Kathmandu",
            "Amsterdam",
            "Willemstad",
            "Wellington",
            "Managua",
            "Niamey",
            "Abuja",
            "Alogi",
            "Kingston",
            "Pyongyang",
            "Oslo",
            "Muscat",
            "Islamabad",
            "Ngerulmud",
            "Panama City",
            "Port Moresby",
            "Asuncion",
            "Lima",
            "Manila",
            "Adamstown",
            "Warsaw",
            "Lisbon",
            "San Juan",
            "Doha",
            "Brazzaville",
            "Bucharest",
            "Moscow",
            "Kigali",
            "Basseterre",
            "Castries",
            "St. Pierre",
            "Kingstown",
            "Apia",
            "San Marino",
            "Sao Tome",
            "Riyadh",
            "Dakar",
            "Belgrad",
            "Victoria",
            "Freetown",
            "Singapore",
            "Bratislava",
            "Ljubljana",
            "Honiara",
            "Mogadishu",
            "Pretoria, Cape Town, and Bloemfontein",
            "King Edward Point",
            "Seoul",
            "Moscow",
            "Madrid",
            "Sri Jayawardenepura Kotte",
            "Khartoum",
            "Paramaribo",
            "Mbabane",
            "Stockholm",
            "Bern",
            "Damascus",
            "Taipei",
            "Dushanbe",
            "Dodoma",
            "Bangkok",
            "Lhasa",
            "Dili",
            "Lome",
            "Nuku alofa",
            "Port of Spain",
            "Tunis",
            "Ankara",
            "Ashgabat",
            "Cockburn Town",
            "Funafuti",
            "Abu Dhabi",
            "Kampala",
            "Kiev",
            "London",
            "Washington",
            "Montevideo",
            "Charlotte Amalie",
            "Tashkent",
            "Port Vila",
            "Vatican City",
            "Caracas",
            "Hanoi",
            "Mata-Utu",
            "Sana a",
            "Lusaka",
            "Harare",
    };
    String[] countryNames = {
            "Afghanistan",
            "Albania",
            "Algeria",
            "Amerikan Samoa",
            "Andorra",
            "Angola",
            "Anguilla",
            "Antigua ja Barbuda",
            "Argentiina",
            "Armenia",
            "Aruba",
            "Australia",
            "Itävalta",
            "Azerbaidzan",
            "Bahama",
            "Bahrain",
            "Bangladesh",
            "Barbados",
            "Valko-Venäjä",
            "Belgia",
            "Belize",
            "Benin",
            "Bermuda",
            "Bhutan",
            "Bolivia",
            "Bosnia-Hertsegovina",
            "Botswana",
            "Brasilia",
            "Brittiläiset Neitsytsaaret",
            "Brunei",
            "Bulgaria",
            "Burkina Faso",
            "Burundi",
            "Kambodza",
            "Kamerun",
            "Kanada",
            "Kap Verde",
            "Caymansaaret",
            "Keski-Afrikan tasavalta",
            "Tsad",
            "Chile",
            "Kiina",
            "Joulusaari",
            "Kolumbia",
            "Komorit",
            "Cook-Saaret",
            "Costa Rica",
            "Norsunluurannikko",
            "Kroatia",
            "Kuuba",
            "Kypros",
            "Pohjois-Kypros",
            "Tsekki",
            "Kongon demokraattinen tasavalta",
            "Tanska",
            "Djibouti",
            "Dominica",
            "Dominikaaninen tasavalta",
            "Ecuador",
            "Egypti",
            "El Salvador",
            "Päiväntasaajan Guinea",
            "Eritrea",
            "Viro",
            "Etiopia",
            "Falklandinsaaret",
            "Färsaaret",
            "Fidzi",
            "Suomi",
            "Ranska",
            "Ranskan Polynesia",
            "Gabon",
            "Gambia",
            "Georgia",
            "Saksa",
            "Ghana",
            "Gibraltar",
            "Kreikka",
            "Grönlanti",
            "Grenada",
            "Guam",
            "Guatemala",
            "Guinea",
            "Guinea-Bissau",
            "Guyana",
            "Haiti",
            "Honduras",
            "Hongkong",
            "Unkari",
            "Islanti",
            "Intia",
            "Indonesia",
            "Iran",
            "Irak",
            "Irlanti",
            "Israel",
            "Italia",
            "Jamaika",
            "Japani",
            "Jordania",
            "Kazakstan",
            "Kenia",
            "Kiribati",
            "Kuwait",
            "Kirgisia",
            "Laos",
            "Latvia",
            "Libanon",
            "Lesotho",
            "Liberia",
            "Libya",
            "Liechtenstein",
            "Liettua",
            "Luxemburg",
            "Macao",
            "Makedonia",
            "Madagaskar",
            "Malawi",
            "Malesia",
            "Malediivit",
            "Mali",
            "Malta",
            "Marshallinsaaret",
            "Martinique",
            "Mauritania",
            "Mauritius",
            "Meksiko",
            "Mikronesia",
            "Moldova",
            "Monaco",
            "Mongolia",
            "Montenegro",
            "Montserrat",
            "Marokko",
            "Mosambik",
            "Myanmar",
            "Namibia",
            "Nauru",
            "Nepali",
            "Alankomaat",
            "Alankomaiden Antillit",
            "Uusi-Seelanti",
            "Nicaragua",
            "Niger",
            "Nigeria",
            "Niue",
            "Norfolkinsaari",
            "Pohjois-Korea",
            "Norja",
            "Oman",
            "Pakistan",
            "Palau",
            "Panama",
            "Papua-Uusi-Guinea",
            "Paraguay",
            "Peru",
            "Filippiinit",
            "Pitcairnsaaret",
            "Puola",
            "Portugali",
            "Puerto Rico",
            "Qatar",
            "Kongon tasavalta",
            "Romania",
            "Venäjä",
            "Ruanda",
            "Saint Kitts ja Nevis",
            "Saint Lucia",
            "Saint-Pierre",
            "Saint Vincent ja Grenadiinit",
            "Samoa",
            "San Marino",
            "Sao Tome ja Principe",
            "Saudi-Arabia",
            "Senegal",
            "Serbia",
            "Seychellit",
            "Sierra Leone",
            "Singapore",
            "Slovakia",
            "Slovenia",
            "Solomaninsaaret",
            "Somalia",
            "Etelä-Afrikka",
            "Etelä-Georgia",
            "Etelä-Korea",
            "Neuvostoliitto",
            "Espanja",
            "Sri Lanka",
            "Sudan",
            "Suriname",
            "Swazimaa",
            "Ruotsi",
            "Sveitsi",
            "Syyria",
            "Taiwan",
            "Tadzikistan",
            "Tansania",
            "Thaimaa",
            "Tiibet",
            "Itä-Timor",
            "Togo",
            "Tonga",
            "Trinidad ja Tobago",
            "Tunisia",
            "Turkki",
            "Turkmenistan",
            "Turks- ja Caicossaaret",
            "Tuvalu",
            "Yhdistyneet arabiemiirikunnat",
            "Uganda",
            "Ukraina",
            "Yhdistynyt kuningaskunta",
            "Yhdysvallat",
            "Uruguay",
            "Yhdysvaltain Neitsytsaaret",
            "Uzbekistan",
            "Vanuatu",
            "Vatikaani",
            "Venezuela",
            "Vietnam",
            "Wallis ja Futuna",
            "Jemen",
            "Sambia",
            "Zimbabwe"
    };
    int[] countryFlags = {
            R.drawable.afghanistan,
            R.drawable.albania,
            R.drawable.algeria,
            R.drawable.american_samoa,
            R.drawable.andorra,
            R.drawable.angola,
            R.drawable.anguilla,
            R.drawable.antigua_and_barbuda,
            R.drawable.argentina,
            R.drawable.armenia,
            R.drawable.aruba,
            R.drawable.australia,
            R.drawable.austria,
            R.drawable.azerbaijan,
            R.drawable.bahamas,
            R.drawable.bahrain,
            R.drawable.bangladesh,
            R.drawable.barbados,
            R.drawable.belarus,
            R.drawable.belgium,
            R.drawable.belize,
            R.drawable.benin,
            R.drawable.bermuda,
            R.drawable.bhutan,
            R.drawable.bolivia,
            R.drawable.bosnia,
            R.drawable.botswana,
            R.drawable.brazil,
            R.drawable.british_virgin_islands,
            R.drawable.brunei,
            R.drawable.bulgaria,
            R.drawable.burkina_faso,
            R.drawable.burundi,
            R.drawable.cambodia,
            R.drawable.cameroon,
            R.drawable.canada,
            R.drawable.cape_verde,
            R.drawable.cayman_islands,
            R.drawable.central_african_republic,
            R.drawable.chad,
            R.drawable.chile,
            R.drawable.china,
            R.drawable.christmas_island,
            R.drawable.colombia,
            R.drawable.comoros,
            R.drawable.cook_islands,
            R.drawable.costa_rica,
            R.drawable.cote_divoire,
            R.drawable.croatia,
            R.drawable.cuba,
            R.drawable.cyprus,
            R.drawable.cyprus_northern,
            R.drawable.czech_republic,
            R.drawable.democratic_republic_of_the_congo,
            R.drawable.denmark,
            R.drawable.djibouti,
            R.drawable.dominica,
            R.drawable.dominican_republic,
            R.drawable.ecuador,
            R.drawable.egypt,
            R.drawable.el_salvador,
            R.drawable.equatorial_guinea,
            R.drawable.eritrea,
            R.drawable.estonia,
            R.drawable.ethiopia,
            R.drawable.falkland_islands,
            R.drawable.faroe_islands,
            R.drawable.fiji,
            R.drawable.finland,
            R.drawable.france,
            R.drawable.french_polynesia,
            R.drawable.gabon,
            R.drawable.gambia,
            R.drawable.georgia,
            R.drawable.germany,
            R.drawable.ghana,
            R.drawable.gibraltar,
            R.drawable.greece,
            R.drawable.greenland,
            R.drawable.grenada,
            R.drawable.guam,
            R.drawable.guatemala,
            R.drawable.guinea,
            R.drawable.guinea_bissau,
            R.drawable.guyana,
            R.drawable.haiti,
            R.drawable.honduras,
            R.drawable.hong_kong,
            R.drawable.hungary,
            R.drawable.iceland,
            R.drawable.india,
            R.drawable.indonesia,
            R.drawable.iran,
            R.drawable.iraq,
            R.drawable.ireland,
            R.drawable.israel,
            R.drawable.italy,
            R.drawable.jamaica,
            R.drawable.japan,
            R.drawable.jordan,
            R.drawable.kazakhstan,
            R.drawable.kenya,
            R.drawable.kiribati,
            R.drawable.kuwait,
            R.drawable.kyrgyzstan,
            R.drawable.laos,
            R.drawable.latvia,
            R.drawable.lebanon,
            R.drawable.lesotho,
            R.drawable.liberia,
            R.drawable.libya,
            R.drawable.liechtenstein,
            R.drawable.lithuania,
            R.drawable.luxembourg,
            R.drawable.macao,
            R.drawable.macedonia,
            R.drawable.madagascar,
            R.drawable.malawi,
            R.drawable.malaysia,
            R.drawable.maldives,
            R.drawable.mali,
            R.drawable.malta,
            R.drawable.marshall_islands,
            R.drawable.martinique,
            R.drawable.mauritania,
            R.drawable.mauritius,
            R.drawable.mexico,
            R.drawable.micronesia,
            R.drawable.moldova,
            R.drawable.monaco,
            R.drawable.mongolia,
            R.drawable.montenegro,
            R.drawable.montserrat,
            R.drawable.morocco,
            R.drawable.mozambique,
            R.drawable.myanmar,
            R.drawable.namibia,
            R.drawable.nauru,
            R.drawable.nepal,
            R.drawable.netherlands,
            R.drawable.netherlands_antilles,
            R.drawable.new_zealand,
            R.drawable.nicaragua,
            R.drawable.niger,
            R.drawable.nigeria,
            R.drawable.niue,
            R.drawable.norfolk_island,
            R.drawable.north_korea,
            R.drawable.norway,
            R.drawable.oman,
            R.drawable.pakistan,
            R.drawable.palau,
            R.drawable.panama,
            R.drawable.papua_new_guinea,
            R.drawable.paraguay,
            R.drawable.peru,
            R.drawable.philippines,
            R.drawable.pitcairn_islands,
            R.drawable.poland,
            R.drawable.portugal,
            R.drawable.puerto_rico,
            R.drawable.qatar,
            R.drawable.republic_of_the_congo,
            R.drawable.romania,
            R.drawable.russian_federation,
            R.drawable.rwanda,
            R.drawable.saint_kitts_and_nevis,
            R.drawable.saint_lucia,
            R.drawable.saint_pierre,
            R.drawable.saint_vicent_and_the_grenadines,
            R.drawable.samoa,
            R.drawable.san_marino,
            R.drawable.sao_tome_and_principe,
            R.drawable.saudi_arabia,
            R.drawable.senegal,
            R.drawable.serbia,
            R.drawable.seychelles,
            R.drawable.sierra_leone,
            R.drawable.singapore,
            R.drawable.slovakia,
            R.drawable.slovenia,
            R.drawable.soloman_islands,
            R.drawable.somalia,
            R.drawable.south_africa,
            R.drawable.south_georgia,
            R.drawable.south_korea,
            R.drawable.soviet_union,
            R.drawable.spain,
            R.drawable.sri_lanka,
            R.drawable.sudan,
            R.drawable.suriname,
            R.drawable.swaziland,
            R.drawable.sweden,
            R.drawable.switzerland,
            R.drawable.syria,
            R.drawable.taiwan,
            R.drawable.tajikistan,
            R.drawable.tanzania,
            R.drawable.thailand,
            R.drawable.tibet,
            R.drawable.timor_leste,
            R.drawable.togo,
            R.drawable.tonga,
            R.drawable.trinidad_and_tobago,
            R.drawable.tunisia,
            R.drawable.turkey,
            R.drawable.turkmenistan,
            R.drawable.turks_and_caicos_islands,
            R.drawable.tuvalu,
            R.drawable.uae,
            R.drawable.uganda,
            R.drawable.ukraine,
            R.drawable.united_kingdom,
            R.drawable.united_states_of_america,
            R.drawable.uruguay,
            R.drawable.us_virgin_islands,
            R.drawable.uzbekistan,
            R.drawable.vanuatu,
            R.drawable.vatican_city,
            R.drawable.venezuela,
            R.drawable.vietnam,
            R.drawable.wallis_and_futuna,
            R.drawable.yemen,
            R.drawable.zambia,
            R.drawable.zimbabwe
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        mListView = findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(Browse.this, countryNames, capitalNames, countryFlags);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(Browse.this, DetailActivity.class);
                mIntent.putExtra("countryName", countryNames[i]);
                mIntent.putExtra("countryFlag", countryFlags[i]);
                mIntent.putExtra("capitalName", capitalNames[i]);
                startActivity(mIntent);

            }
        });




    }
}
