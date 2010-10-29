import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.Key

log.info "Updating goal"

def id = Long.parseLong(params.id)
Key key = KeyFactory.createKey("Goal", id)
def goal = datastore.get(key)
goal.name = params.name
goal.description = params.description
goal.save()

redirect '/goals'