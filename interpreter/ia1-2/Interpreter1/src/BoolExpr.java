/**
 *
 * @author reuben
 */
public class BoolExpr {
    private final String relop;
    private final NodeExpr lhs;
    private final NodeExpr rhs;
    
    public BoolExpr(NodeExpr lhs, String relop, NodeExpr rhs)
    {
        this.relop = relop;
        this.lhs = lhs;
        this.rhs = rhs;
    }
    
    public boolean eval(Environment env) throws EvalException
    {
        double rightHandVal = rhs.eval(env);
        double leftHandVal = lhs.eval(env);
        switch (relop)
        {
            case "==":
                return leftHandVal == rightHandVal;
            case "<>":
                return leftHandVal != rightHandVal;
            case "<=":
                return leftHandVal <= rightHandVal;
            case ">=":
                return leftHandVal >= rightHandVal;
            case "<":
                return leftHandVal <  rightHandVal;
            case ">":
                return leftHandVal >  rightHandVal;
            default:
                throw new EvalException(0, "Relational operator not recognized");
        }
    }
}
