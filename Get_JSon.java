public class GetJSon {
        private void retrieveJson(){
                try{
                    RequestQueue mRequestQueue;
                    Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
                    Network network = new BasicNetwork(new HurlStack());
                    mRequestQueue = new RequestQueue(cache, network);
                    mRequestQueue.start();

                    String url = "URL";
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                            null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                //store or print response here

                                }
                            catch (Exception e) {
                                Log.e("MYAPP", "exception", e);
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("MYAPP", "exception", error);
                        }
                    });
                    MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
                }
                catch(Exception e){
                    Log.e("MYAPP", "exception", e);
                }
            }
}