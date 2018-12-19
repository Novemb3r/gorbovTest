package DBResults;

import Common.Config;
import Database.DBException;
import Database.DBQuery;
import Database.DBStatement;

public class Results {

    public static boolean send(String userId,
                               Long dateBeginFirstStage,
                               Long dateEndFirstStage,
                               Long dateBeginSecondStage,
                               Long dateEndSecondStage,
                               Integer errorsOnFirstStage,
                               Integer errorsOnSecondStage
    ) throws DBException {

        String sDateBeginFirstStage = dateBeginFirstStage.toString();
        String sDateEndFirstStage = dateEndFirstStage.toString();
        String sDateBeginSecondStage = dateBeginSecondStage.toString();
        String sDateEndSecondStage = dateEndSecondStage.toString();
        String sErrorsOnFirstStage = errorsOnFirstStage.toString();
        String sErrorsOnSecondStage = errorsOnSecondStage.toString();


        String query = (new DBQuery())
                .insert(Constants.TABLE_NAME, new String[]{"userId",
                        "dateBeginFirstStage",
                        "dateEndFirstStage",
                        "dateBeginSecondStage",
                        "dateEndSecondStage",
                        "errorsOnFirstStage",
                        "errorsOnSecondStage"
                })
                .values(new String[]{userId,
                        sDateBeginFirstStage,
                        sDateEndFirstStage,
                        sDateBeginSecondStage,
                        sDateEndSecondStage,
                        sErrorsOnFirstStage,
                        sErrorsOnSecondStage
                })
                .getQuery();

        int i = (new DBStatement(Config.conn)).executeUpdate(query);

        return (i != 0);
    }
}
