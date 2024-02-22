public class Main {

    public static String compressString(String input){
        if (input == null || input.isEmpty()){
            return input;
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int reps;
        while (idx < input.length() - 1){
            reps = 1;
            while (input.charAt(idx) == input.charAt(idx+1)){
                idx++;
                reps++;
            }
            sb.append(input.charAt(idx));
            if (reps > 1) {
                sb.append(reps);
            }
            idx++;
        }
        if (input.charAt(input.length()-1) != input.charAt(input.length()-2)){
            sb.append(input.charAt(input.length()-1));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String in = "aaabbcddddeffggggghhijklmmnnno";
        System.out.println("This method optimally compresses single-letter clusters in a string");
        System.out.println("Input: " + in);
        System.out.println("Compressed output: " + compressString(in));
    }
}
