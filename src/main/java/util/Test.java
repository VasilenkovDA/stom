package util;

import sql.Requests;
import sql.SqlHelper;


public class Test {
    private static SqlHelper sqlHelper;


    public static void main(String[] args) {
        sqlHelper = new SqlHelper(Config.get().getDbUrl(), Config.get().getDbUser(), Config.get().dbPassword());
//        Requests requests = Config.get().getRequests();

        sqlHelper.execute("select * from city where resume_uuid = ?", ps -> {
            ps.setString(1, uuid);
            if (ps.executeUpdate() == 0) {
                throw new NotExistStorageException(uuid);
            }
            return null;
        });
    }
}

