function(nm,$mpt){
  var mm=getrtmm$$(this.tipo);
  var fnOld=mm.d[mm.d.length-1]+"_"+(nm===''?'$c$':nm);
  var fnNew=mm.d[mm.d.length-1]+"$c_"+(nm===''?'$c$':nm);
  var cn=this.tipo[fnNew]||this.tipo[fnOld];
  if (cn) {
    mm=getrtmm$$(cn);
    if (mm.d[mm.d.length-2]==='$cn') {
      validate$params(mm.ps,$mpt.Arguments$getDeclaredConstructor,"Wrong number of Arguments for getConstructor");
      var args=mm.ps?tupleize$params(mm.ps,this.$targs):empty();
      var r=AppliedCallableConstructor$jsint(cn,{Type$AppliedCallableConstructor:this.$$targs$$.Type$AppliedClass,
            Arguments$AppliedCallableConstructor:args},undefined,this.$targs);
      r.cont$=this;
      return r;
    }
  }
  return null;
}
