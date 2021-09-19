public class Predictor{

    static String finalClothes;

    static String[] upperAccessoriesM = new String[]{"Gloves", "Cap","Sun Glasses","Umbrella","Scarf"};
    static String[] upperClothesM = new String[] {"Heavy Jacket","Hoodie","Sweater","Light Jacket","Longsleeve","T-Shirt","Tank Top"};
    static String[] lowerClothesM = new String[] {"Ski Pants", "Sweatpants", "Joggers", "Jeans", "Khakis", "Shorts","Gym Shorts"};
    static String[] lowerAccessoriesM = new String[]{"Flip flops","Running Shoes","Boots","Vans","Walking shoes"};

    static String[] upperAccessoriesF = new String[]{"Gloves", "Cap","Sun Glasses","Umbrella","Scarf"};
    static String[] upperClothesF = new String[] {"Heavy Jacket","Hoodie","Sweater","Light Jacket","Longsleeve","T-Shirt","Tank Top"};
    static String[] lowerClothesF = new String[]{"Ski Pants","Sweatpants", "Jeans", "Joggers", "Khakis","Shorts","Gym Shorts"};
    static String[] lowerAccessoriesF = new String[]{"Flip flops","Running Shoes","Boots","Vans","Walking shoes","Heels"};

    static String[] sexes = new String[]{"male", "female"};


        public String getFinalClothes(int originalClothes){
            int magicNum = 7 * originalClothes;
            int calc = magicNum + main.newTemp;

            if (calc < 20) {
                finalClothes = (upperClothesM[0] + " with a " + upperClothesM[2] + " underneath, as well as some thick " + lowerClothesM[0]);//Heavy Jacket, sweater,ski pants
                return finalClothes;
            } else if (calc < 40 && calc > 20) {
                finalClothes = (upperClothesM[1] + " with " + lowerClothesM[2]);//hoodie, jeans
                return finalClothes;
            } else if (calc < 60 && calc > 40) {
                finalClothes = (upperClothesM[2] + " with " + lowerClothesM[2]);//Sweater jeans
                return finalClothes;
            } else if (calc < 70 && calc > 60) {
                finalClothes = (upperClothesM[3] + " with either " + lowerClothesM[2] + " or " + lowerClothesM[4]);//light jacket, jeans or shorts
                return finalClothes;
            } else if (calc < 100 && calc > 70) {
                finalClothes = (upperClothesM[5] + " with " + lowerClothesM[5]);//t-shirt and shorts
                return finalClothes;
            }
            return null;
        }



}