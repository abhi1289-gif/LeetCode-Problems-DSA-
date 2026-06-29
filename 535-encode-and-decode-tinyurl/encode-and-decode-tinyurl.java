public class Codec {

    HashMap<String, String> mapp = new HashMap<>();
    int a = 1;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = String.valueOf(a);
        a++;
        mapp.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mapp.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));