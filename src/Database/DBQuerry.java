package Database;

/**
 * Класс для сборки SQL запросов
 *
 * @TODO: экранирование символов
 */
public class DBQuerry {

    private String querryStatement = "";

    /**
     * Добавляет select * к запросу
     *
     * @return DBQuerry
     */
    public DBQuerry select() {
        this.querryStatement += "SELECT * ";
        return this;
    }

    /**
     * Добавляет select к запросу
     *
     * @return DBQuerry
     */
    public DBQuerry select(String fields) {
        this.querryStatement += "SELECT " + fields + " ";
        return this;
    }

    /**
     * Добавляет update к запросу
     *
     * @return DBQuerry
     */
    public DBQuerry update() {
        this.querryStatement += "UPDATE ";
        return this;
    }

    /**
     * Добавляет delete к запросу
     *
     * @return DBQuerry
     */
    public DBQuerry delete() {
        this.querryStatement += "DELETE ";
        return this;
    }

    /**
     * Добавляет from к запросу
     *
     * @param table название таблицы для получения данных
     * @return DBQuerry
     */
    public DBQuerry from(String table) {
        this.querryStatement += "FROM " + table + " ";
        return this;
    }

    /**
     * Добавляет where к запросу
     * @TODO: мапать результаты
     *
     * @param condition условия для поиска
     * @return DBQuerry
     */
    public DBQuerry where(String condition) {
        this.querryStatement += "WHERE " + condition;
        return this;
    }

    /**
     * Вернет сформированную строку запроса
     *
     * @return String
     */
    public String getQuerry() {
        return this.querryStatement;
    }

    /**
     * Очистит запрос
     */
    public void clear() {
        this.querryStatement = "";
    }
}
