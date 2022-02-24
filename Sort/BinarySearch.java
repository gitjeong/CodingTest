package Sort;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int index = nums.length/2;
        if(nums.length <= 1 && nums[0] != target) {return -1;}
        else if(nums[index] == target){return index;}
        else if(nums[index] > target){return search(nums, target, 0, index);}
        else{return search(nums, target, index+1, nums.length);}
    }

    public int search(int[] nums, int target, int start, int end){
        int index = (end + start)/2;
        if((start == end) || (start+1==end && nums[start] != target)) {return -1;}
        else if(nums[index] == target) {return index;}
        else if(nums[index] > target) {return search(nums, target, start, index);}
        else {return search(nums, target, index+1, end);}
    }

    public static void main(String[] args){
        BinarySearch t = new BinarySearch();
        System.out.println(t.search(new int[]{-1,0,3,5,9,12},13));
    }
}
