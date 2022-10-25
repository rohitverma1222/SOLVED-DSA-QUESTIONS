/**
 * @param {number[]} nums
 * @return {number}
 */
    var totalPair=(pair)=>{
        return pair*(pair-1)/2;
    }
var countBadPairs = function(nums) {
    
    const map = new Map();
    for(let i=0;i<nums.length;i++)
        {
            let val=i-nums[i];
            if(map.has(val))
                map.set(val,map.get(val)+1);
            else
                map.set(val,1);
        }
    
    let sum=totalPair(nums.length);
    
    for(val of map.values())
        sum-=totalPair(val);
    return sum;
};