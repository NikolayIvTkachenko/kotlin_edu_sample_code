package org.example.patterns.behavior_patterns.interpreter


class WhereClause(private val conditions: String) {
    override fun toString(): String {
        return "WHERE $conditions"
    }
}

class FromClause(private val table: String) {
    private lateinit var where: WhereClause
    fun where(conditions: String) = this.apply {
        where = WhereClause(conditions)
    }
    override fun toString(): String {
        return "FROM $table ${this.where}"
    }
}

class SelectClause(private val columns: String) {
    private lateinit var from: FromClause
    fun from(table: String, where: FromClause.() -> Unit): FromClause {
        this.from = FromClause(table)
        return this.from.apply(where)
    }

    override fun toString(): String {
        return "SELECT $columns ${this.from}"
    }
}

fun select(columns: String, from: SelectClause.() -> Unit): SelectClause {
    return SelectClause(columns).apply(from)
}

fun main() {
    val sql = select(
        "name, age", {
            from("users", {
                where ("age > 25")
            })
        })
    println(sql)
}