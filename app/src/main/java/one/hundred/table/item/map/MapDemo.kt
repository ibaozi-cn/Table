package one.hundred.table.item.map

/**
 * Created by zzy on 2017/10/13.
 */
class MapDemo(val map: MutableMap<String, Any> = mutableMapOf()) {

    var name by map

    var old by map

    fun map(serverData: ServerData) = apply {
        //注意map映射中 如果serverData某个属性为空必须赋值，否则报空指针：如下写法是安全的
        this.name = serverData.serverName ?: ""
        this.old = serverData.serverOld ?: ""
    }

}

data class ServerData(val serverName: String?, val serverOld: String?)