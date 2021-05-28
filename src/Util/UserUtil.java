package Util;

/**
 * @description: Util functions for user operation and checks
 * @author: Haopu Chen
 **/
public class UserUtil {
    public static boolean checkExerciseBookable(int traineeType, int trainerLevel){
        if(traineeType==2){
            if(trainerLevel<2){
                return true;
            }
        }else if(traineeType==3){
            return true;
        }
        return false;
    }
}
