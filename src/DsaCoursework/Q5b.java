package DsaCoursework;
import java.util.Arrays;
public class Q5b {
        public static int batteryReplacement(int[][] service_centers, int target_miles, int startChargeCapacity) {
            Arrays.sort(service_centers, (a, b) -> a[0] - b[0]); // sort the service centers by distance from source city
            int count = 0; // count of battery replacements
            int currentMiles = startChargeCapacity; // current miles the car can travel
            int i = 0; // index of the current service center
            while (currentMiles < target_miles) { // while the car hasn't reached its destination
                int maxMiles = 0; // max miles the car can travel after battery replacement
                while (i < service_centers.length && service_centers[i][0] <= currentMiles) { // find the next service center that can be reached with current battery capacity
                    maxMiles = Math.max(maxMiles, service_centers[i][1]); // update the max miles with the capacity of the current service center
                    i++; // move to the next service center
                }
                if (maxMiles == 0) { // if no service center can be reached with current battery capacity
                    return -1; // return -1 to indicate that the destination cannot be reached
                }
                currentMiles = maxMiles + currentMiles; // replace the battery and update the current miles
                count++; // increment the count of battery replacements
            }
            return count; // return the count of battery replacements
        }

        public static void main(String[] args) {
            int[][] serviceCenters = {{10,60},{20,30},{30,30},{60,40}};
            int targetMiles = 100;
            int startChargeCapacity = 10;
            System.out.println(batteryReplacement(serviceCenters, targetMiles, startChargeCapacity)); // output: 3
        }


}
