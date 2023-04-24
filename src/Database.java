/*

----Constructor (oluşturucu metotu) private olmalıdır. Bunun amacı nesne oluşumunu tek yerden sağlamak.
İstemcinin, new anahtar kelimesini kullanması engellemektir.
----Static bir değişken olmalıdır, referansı tutmak için.
----Tutulan referansa erişmek için bir metot olmalıdır, getInstance()

 */
public class Database {

    private static Database database;
    private static Object _synchronizedObject = new Object();

    /*
     ----if (database == null) durumuna aynı anda birden fazla thread girebilir,
     ----Bu sayede de o sınıfa ait birden fazla nesne örneği bulunur.
     synchronized sayesinde aynı anda sadece bir yapının erişmesini sağlarız

     */

    private Database() {

    }

    public static Database getInstance() {
        if (database == null) {

            synchronized (_synchronizedObject) {
                if (database == null) {
                    database = new Database();
                }
            }
        }
        return database;
    }

}


