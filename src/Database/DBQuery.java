package Database;

/**
 * Класс для сборки SQL запросов
 *
 * @TODO: экранирование символов
 */
public class DBQuery {

    private String queryStatement = "";

    /**
     * Добавляет select * к запросу
     *
     * @return DBQuery
     */
    public DBQuery select() {
        this.queryStatement += "SELECT * ";
        return this;
    }

    /**
     * Добавляет select к запросу
     *
     * @return DBQuery
     */
    public DBQuery select(String fields) {
        this.queryStatement += "SELECT " + fields + " ";
        return this;
    }

    /**
     * Добавляет update к запросу
     *
     * @return DBQuery
     */
    public DBQuery update() {
        this.queryStatement += "UPDATE ";
        return this;
    }

    /**
     * Добавляет delete к запросу
     *
     * @return DBQuery
     */
    public DBQuery delete() {
        this.queryStatement += "DELETE ";
        return this;
    }

    /**
     * Добавляет delete к запросу
     *
     * @return DBQuery
     */
    public DBQuery insert(String table) {
        this.queryStatement += "INSERT INTO " + table + " ";
        return this;
    }

    /**
     * Добавляет from к запросу
     *
     * @param table название таблицы для получения данных
     * @return DBQuery
     */
    public DBQuery from(String table) {
        this.queryStatement += "FROM " + table + " ";
        return this;
    }

    /**
     * Добавляет where к запросу
     *
     * @param condition условие для поиска
     * @return DBQuery
     */
    public <T> DBQuery where(String condition, T value) {
        this.queryStatement += "WHERE " + condition.replace("?", value.toString());
        return this;
    }

    /**
     * Добавляет where к запросу
     *
     * @param conditions условие для поиска
     * @param values     значения условий
     * @return DBQuery
     */
    public <T> DBQuery where(String[] conditions, T[] values) {
        this.queryStatement += "WHERE ";

        for (int i = 0; i < conditions.length; i++) {
            this.queryStatement += conditions[i].replaceFirst("\\?", values[i].toString()) + " AND ";
        }

        this.queryStatement = this.queryStatement.substring(0, queryStatement.length() - 5);

        return this;
    }

    /**
     * Добавляет where к запросу
     *
     * @param condition условие для поиска
     * @return DBQuery
     */
    public DBQuery where(String condition) {
        this.queryStatement += "WHERE " + condition;
        return this;
    }

    /**
     * Добавляет where к запросу
     *
     * @param conditions условия для поиска
     * @return DBQuery
     */
    public DBQuery where(String[] conditions) {
        this.queryStatement += "WHERE ";

        for (String condition : conditions) {
            this.queryStatement += condition + " AND ";
        }

        this.queryStatement = this.queryStatement.substring(0, queryStatement.length() - 5);

        return this;
    }

    /**
     * Добавляет and к запросу
     *
     * @return DBQuerry
     */
    public DBQuery and() {
        this.queryStatement += "AND ";
        return this;
    }

    /**
     * Добавляет set к запросу
     *
     * @param condition условие для поиска
     * @return DBQuery
     */
    public DBQuery set(String condition) {
        this.queryStatement += "SET " + condition;
        return this;
    }

    /**
     * Вернет сформированную строку запроса
     *
     * @return String
     */
    public String getQuery() {
        return this.queryStatement;
    }

    /**
     * Очистит запрос
     */
    public void clear() {
        this.queryStatement = "";
    }
}
