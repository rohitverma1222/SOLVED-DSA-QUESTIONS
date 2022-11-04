public class Codec {

    HashMap<Integer,String> hs=new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int val=longUrl.hashCode();
        hs.put(val,longUrl);
        return "http://tinyurl.com/"+val;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String spl[]=shortUrl.split("/");
        int ans=Integer.parseInt(spl[spl.length-1]);
        return hs.get(ans);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));