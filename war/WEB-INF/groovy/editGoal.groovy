import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.Key

log.info "Editing goal"

def id = Long.parseLong(params.id)
Key key = KeyFactory.createKey("Goal", id)
def goal = datastore.get(key)

request.goal = goal
forward '/WEB-INF/pages/goal.gtpl'
