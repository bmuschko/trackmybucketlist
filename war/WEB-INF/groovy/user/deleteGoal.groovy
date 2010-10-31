import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.Key

log.info "Deleting goal"

def id = Long.parseLong(params.id)
Key key = KeyFactory.createKey("Goal", id)
key.delete()

redirect '/user/goals'