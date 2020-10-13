package sql;

import sql.SqlHelper;

public class Requests {
    private SqlHelper sqlHelper;

    public Requests(SqlHelper sqlHelper) {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        this.sqlHelper = sqlHelper;
    }

}
