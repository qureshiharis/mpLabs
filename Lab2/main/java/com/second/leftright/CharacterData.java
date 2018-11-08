package com.second.leftright;

public class CharacterData {
    private static String[][] MyCharacter = {

            { "Chandler Bing", "29", "IT Procurement Manager" },
            { "Monica Geller", "28", "Head Chef" },
            { "Joey Tribbiani", "30", "Actor" },
            { "Rachel Green", "29", "Executive at Ralph Lauren" },
            { "Ross Geller", "30", "Paleontologist" },
            { "Phoebe Buffay", "30", "Masseuse " }

    };

    private static int[] MyCharacterImage = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6
    };

    public static String getCharacterName(int a) {

        String name = MyCharacter[a][0];
        return name;
    }

    public static String getCharacterAge(int a) {
        String age = MyCharacter[a][1];
        return age;
    }

    public static String getCharacterJob(int a) {
        String job = MyCharacter[a][2];
        return job;
    }

    public static int getCharacterPicture(int a) {
        int imageID = MyCharacterImage[a];
        return imageID;
    }

}
