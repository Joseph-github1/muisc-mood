import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class Main {

        public static void main(String[] args) {

            // 1. unique Spotify ID and Secret
            String clientId = "051db2d4b6374ecd8955f078e6df1ff7"; // Like your username.
            String clientSecret = "41e38a62edb84976990ac730ccdfd57d"; // Like your password.

            // 2. Combine them into one string and encode it securely.
            String authString = clientId + ":" + clientSecret;
            String encodedAuth = Base64.getEncoder().encodeToString(authString.getBytes()); // Makes it safe to send.

            // 3. Create the "form" we’ll send to Spotify.
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://accounts.spotify.com/api/token")) // Go to Spotify’s token desk.
            .header("Authorization", "Basic " + encodedAuth) // Show Spotify your ID and secret.
            .header("Content-Type", "application/x-www-form-urlencoded") // Tell Spotify what kind of form we’re sending.
            .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials")) // Say, "I want general access."
            .build();

            HttpResponse<String> response = null;
            try {
                // 4. Send the request and get Spotify’s response.
                HttpClient client = HttpClient.newHttpClient();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception a) {
                System.out.println("error");
            }
            // 5. Print out Spotify's response.
            System.out.println("Response Code: " + response.statusCode()); // Check if it worked (200 means success).
            System.out.println("Response Body: " + response.body()); // This is the token we need!
               {
            }
        }

        }





